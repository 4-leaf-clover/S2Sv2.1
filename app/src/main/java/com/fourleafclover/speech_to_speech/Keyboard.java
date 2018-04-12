package com.fourleafclover.speech_to_speech;


import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.KeyboardView;
import android.media.AudioManager;
import android.os.Handler;
import android.os.IBinder;
import android.speech.tts.TextToSpeech;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import android.widget.Toast;

import com.google.cloud.android.speech.SpeechService;
import com.google.cloud.android.speech.VoiceRecorder;

import java.util.Locale;
import java.util.Random;

/**
 * Displays a custom keyboard that is used by the user to enter text into the specified input method by the user
 * <p>
 * <p>Implements {@link KeyboardView} and extends {@link InputMethodService} to create a custom
 * keyboard that the user interacts with to accept, modify, and reject text that the user wants to input into the
 * smart device using his/her voice</p>
 */
public class Keyboard extends InputMethodService implements KeyboardView.OnKeyboardActionListener {

    /**
     * The keyboard that the user sees
     */
    private KeyboardView kv;
    /**
     * Layout of the keyboard and the buttons
     */
    private android.inputmethodservice.Keyboard keyboardLayout;

    /**
    * Log TAGS
    */
    private final String[] TAGS = {"Keyboard", "STT", "TTS"};

    /**
    * Keyboard key code for implementing action listeners
    */
    private final int KEYBOARD_LEFT = 100004;
    /**
     * Keyboard key code for implementing action listeners
     */
    private final int KEYBOARD_RIGHT = 100003;
    /**
     * Keyboard key code for implementing action listeners
     */
    private final int KEYBOARD_RECORD = 100002;
    /**
     * Keyboard key code for implementing action listeners
     */
    private final int KEYBOARD_CONFIRM = 100001;
    /**
     * Keyboard key code for implementing action listeners
     */
    private final int KEYBOARD_REJECT = 100000;


    /**
     * Where the output of the speech-to-text module is displayed
     */
    private TextView preview;
    private InputConnection ic;
    private View root;


    /**
    * Speech to Text Module
    */
    private SpeechService mSpeechService;
    /**
     * Speech to Text Module
     */
    private VoiceRecorder mVoiceRecorder;
    private String buffer;

    /**
    * Text to Speech Module
    */
    private TextToSpeech mTTS;

    /*
    * SPEECH TO TEXT FUNCTIONS
    */
    private final ServiceConnection mServiceConnection = new ServiceConnection() {

        /**
         * Called when the Keyboard first pops up. Implemented by {@link ServiceConnection} dependency
         * @param componentName
         * @param binder
         */
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder binder) {
            Log.d(TAGS[1], "Keyboard class onServiceConnected");
            mSpeechService = SpeechService.from(binder);
            mSpeechService.addListener(mSpeechServiceListener);
        }

        /**
         * Called when the Keyboard shuts down or when there is no
         * internet connection. Implemented by {@link ServiceConnection} dependency
         * @param componentName
         */
        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(TAGS[1], "Keyboard class onServiceDisconnected");
            mSpeechService = null;
        }

    };

    private final VoiceRecorder.Callback mVoiceCallback = new VoiceRecorder.Callback() {

        /**
         *  Called when user first starts speaking
         */
        @Override
        public void onVoiceStart() {
            if (mSpeechService != null) {
                Log.d(TAGS[1], "Keyboard class onVoiceStart");
                mSpeechService.startRecognizing(mVoiceRecorder.getSampleRate());
            }
        }

        @Override
        public void onVoice(byte[] data, int size) {
            if(mSpeechService != null){
                mSpeechService.recognize(data,size);
            }

        }

        /**
         *  Called when user stops speaking
         */
        @Override
        public void onVoiceEnd() {
            if (mSpeechService != null) {
                Log.d(TAGS[1], "Keyboard class onVoiceEnd");
                mSpeechService.finishRecognizing();
            }
        }

    };

    private final SpeechService.Listener mSpeechServiceListener =
            new SpeechService.Listener() {
                @Override
                public void onSpeechRecognized(final String text, final boolean isFinal) {
                    Log.d(TAGS[1], "Keyboard class speech service listener isFinal value: " + isFinal);
                    if (!TextUtils.isEmpty(text)) {
                        if(isFinal){
                            Log.d(TAGS[1],"Preview has been updated");
                            /*
                            *Generate random Utterance ID
                            */
                            String id;
                            Random rn=new Random();
                            id= Integer.valueOf(rn.nextInt(100)).toString();

                            Log.d(TAGS[1], "Keyboard class speech service listener VoiceRecorder dismiss");
                            mVoiceRecorder.dismiss();
                            mTTS.speak(text,TextToSpeech.QUEUE_FLUSH,null,id);
                            Keyboard.this.stopVoiceRecorder();
                        }
                        setPreview(text);

                    }
                }
            };


    /**
     * opens the microphone and starts recording the user's speech
     */
    private void startVoiceRecorder() {
        Log.d("STT", "Voice recording started");
        if (mVoiceRecorder != null) {
            mVoiceRecorder.stop();
        }
        mVoiceRecorder = new VoiceRecorder(mVoiceCallback);
        mVoiceRecorder.start();
    }

    /**
     * stops the microphone and the recording of the user's speech
     */
    private void stopVoiceRecorder() {
        Log.d("STT", "Voice recording stopped");
        if (mVoiceRecorder != null) {
            mVoiceRecorder.stop();
            mVoiceRecorder = null;
        }
    }


     /**
      * Creates the custom keyboard and adds it onto the user's screen.
      * Starts the connection to Google's Speech Service API and binds to it
      * Initializes Android's Text to Speech API and assigns it to a local variable
      * Sets the speed and frequency of the Text to Speech service
     */
    @Override
    public View onCreateInputView() {
        root=getLayoutInflater().inflate(R.layout.keyboard,null);

        preview=(TextView)root.findViewById(R.id.textPreview);
        preview.setText("");

        ic = getCurrentInputConnection();

        keyboardLayout = new android.inputmethodservice.Keyboard(this, R.xml.keyboardlayout);

        kv = (KeyboardView) root.findViewById(R.id.keyboard);
        kv.setKeyboard(keyboardLayout);
        kv.setOnKeyboardActionListener(this);

        Log.d(TAGS[0], "Keyboard successfully created");

        bindService(new Intent(this, SpeechService.class), mServiceConnection, BIND_AUTO_CREATE);
        Log.d(TAGS[1], "STT binded successfully");

        mTTS=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i!=TextToSpeech.ERROR)
                {
                    mTTS.setLanguage(Locale.ENGLISH);
                    mTTS.setPitch(0.7f);
                    mTTS.setSpeechRate(0.7f);
                }
            }
        });
        return root;
    }

    /**
     * Function does nothing. Look at onKey() for more info
     * @param i keyBoard button that was pressed
     */
    @Override
    public void onPress(int i) {}

    /**
     * Function does nothing. Look at onKey() for more info
     * @param i keyBoard button that was pressed
     */
    @Override
    public void onRelease(int i) {}

    /**
     * Function that takes action depending on the key that was tapped.
     * @param i keyBoard button that was pressed
     */
    @Override
    public void onKey(int i, int[] ints) {
        playClick(i);
        switch (i) {
            /**
             * Starts the microphone and starts recording
             */
            case KEYBOARD_RECORD:
                Toast.makeText(this, "Recording", Toast.LENGTH_SHORT).show();
                startVoiceRecorder();
                break;
            /**
             * Goes one word right in the text preview
             */
            case KEYBOARD_RIGHT:
                Toast.makeText(this, "Traversing Right", Toast.LENGTH_SHORT).show();
                //TODO add logic for text traversal
                break;
            /**
             * Goes one word left in the text preview
             */
            case KEYBOARD_LEFT:
                Toast.makeText(this, "Traversing Left", Toast.LENGTH_SHORT).show();
                //TODO add logic for text traversal
                break;
            /**
             * Appends the text onto the input method
             */
            case KEYBOARD_CONFIRM:
                Toast.makeText(this, "Confirm Text", Toast.LENGTH_SHORT).show();
                if(!TextUtils.isEmpty(buffer)) {
                    mTTS.stop();
                    Log.d(TAGS[0],"Text has been confirmed and committed");
                    getCurrentInputConnection().commitText(buffer, 1);
                    preview.setText("");
                }
                break;
            /**
             * Clears the text preview and restarts the microphone
             */
            case KEYBOARD_REJECT:
                Toast.makeText(this, "Reject Text", Toast.LENGTH_SHORT).show();
                mTTS.stop();
                setPreview("");
                break;
            default:
                Log.d(TAGS[0], "Invalid keycode");
        }
    }


    /**
     * Plays a 'click' sound whenever the user taps a button.
     * Can be customized depending on what button the user clicks
     * @param i Key code of the button that was pressed
     */
    private void playClick(int i) {
        AudioManager am = (AudioManager) getSystemService(AUDIO_SERVICE);
        assert am != null;
        am.playSoundEffect(AudioManager.FX_KEY_CLICK);
    }


    /**
     * Intializes the text preview on top of the custom keyboard to whatever is in the
     * buffer
     * @param buffer The text to preview on the keyboard
     */
    private void setPreview(final String buffer){
        this.buffer=buffer;
        Log.d(TAGS[0],"Buffer: "+buffer);
        Handler mainHandler = new Handler(this.getMainLooper());
        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                preview.setText(buffer);
            }
        };
        mainHandler.post(myRunnable);
    }

    @Override
    public void onText(CharSequence charSequence) {}

    @Override
    public void swipeLeft() {}

    @Override
    public void swipeRight() {}

    @Override
    public void swipeDown() {}

    @Override
    public void swipeUp() {}
}

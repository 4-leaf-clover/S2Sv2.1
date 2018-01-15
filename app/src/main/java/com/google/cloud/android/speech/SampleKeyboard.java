package com.google.cloud.android.speech;


import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.media.AudioManager;
import android.os.IBinder;
import android.speech.tts.TextToSpeech;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.Toast;

public class SampleKeyboard extends InputMethodService implements KeyboardView.OnKeyboardActionListener {


    private KeyboardView kv;
    private Keyboard keyboard;

    /*
    * Log Tags
    */
    private final String[] Tags = {"Keyboard", "STT", "TTS"};

    /*
    *
    * Keyboard key codes
    *
    */
    private final int KEYBOARD_LEFT = 100004;
    private final int KEYBOARD_RIGHT = 100003;
    private final int KEYBOARD_RECORD = 100002;
    private final int KEYBOARD_CONFIRM = 100001;
    private final int KEYBOARD_REJECT = 100000;


    /*
    * Speech to Text Variables
    */
    private SpeechService mSpeechService;
    private VoiceRecorder mVoiceRecorder;
    private String buffer;

    /*
    * Text to Speech Variables
    */
    private final String CONFIRM = "Do you confirm the text output?";
    private TextToSpeech mTTS;
    private final int DATA_CHECK_CODE = 0;

    /*
    * SPEECH TO TEXT FUNCTIONS
    */
    private final ServiceConnection mServiceConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder binder) {
            Log.d(Tags[1], "Keyboard class onServiceConnected");
            mSpeechService = SpeechService.from(binder);
            mSpeechService.addListener(mSpeechServiceListener);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(Tags[1], "Keyboard class onServiceDisconnected");
            mSpeechService = null;
        }

    };

    private final VoiceRecorder.Callback mVoiceCallback = new VoiceRecorder.Callback() {

        @Override
        public void onVoiceStart() {
            if (mSpeechService != null) {
                Log.d(Tags[1], "Keyboard class onVoiceStart");
                mSpeechService.startRecognizing(mVoiceRecorder.getSampleRate());
            }
        }

        @Override
        public void onVoice(byte[] data, int size) {
            if (mSpeechService != null) {
                mSpeechService.recognize(data, size);
            }
        }

        @Override
        public void onVoiceEnd() {
            if (mSpeechService != null) {
                Log.d(Tags[1], "Keyboard class onVoiceEnd");
                mSpeechService.finishRecognizing();
            }
        }

    };

    private final SpeechService.Listener mSpeechServiceListener =
            new SpeechService.Listener() {
                @Override
                public void onSpeechRecognized(final String text, final boolean isFinal) {
                    InputConnection ic = getCurrentInputConnection();
                    Log.d(Tags[1], "Keyboard class speech service listener isFinal value: " + isFinal);
                    if (!TextUtils.isEmpty(text) && isFinal) {
                        ic.commitText(text + ". ", 1);
                        Log.d(Tags[1], "Keyboard class speech service listener VoiceRecorder dismiss");
                        mVoiceRecorder.dismiss();
                        SampleKeyboard.this.stopVoiceRecorder();
                    }
                }
            };

    private void startVoiceRecorder() {
        Log.d("STT", "Voice recording started");
        if (mVoiceRecorder != null) {
            mVoiceRecorder.stop();
        }
        mVoiceRecorder = new VoiceRecorder(mVoiceCallback);
        mVoiceRecorder.start();
    }

    private void stopVoiceRecorder() {
        Log.d("STT", "Voice recording stopped");
        if (mVoiceRecorder != null) {
            mVoiceRecorder.stop();
            mVoiceRecorder = null;
        }
    }


    /*
    * OnCreateView for keyboard
    * Assign keyboard view
    * Set Keyboard Layout
    * SetOnKeyListener
    */
    @Override
    public View onCreateInputView() {
        kv = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard, null);
        keyboard = new Keyboard(this, R.xml.keyboardlayout);
        kv.setKeyboard(keyboard);
        kv.setOnKeyboardActionListener(this);

        Log.d(Tags[0], "Keyboard successfully created");

        bindService(new Intent(this, SpeechService.class), mServiceConnection, BIND_AUTO_CREATE);
        Log.d(Tags[1], "Keyboard class createInputView");
        return kv;
    }

    @Override
    public void onPress(int i) {

    }

    @Override
    public void onRelease(int i) {

    }

    /*
    * Handle Keyboard input
    * */
    @Override
    public void onKey(int i, int[] ints) {
        InputConnection ic = getCurrentInputConnection();
        playClick(i);
        switch (i) {
            case KEYBOARD_RECORD:
                Toast.makeText(this, "Recording", Toast.LENGTH_SHORT).show();
                startVoiceRecorder();
                break;
            case KEYBOARD_RIGHT:
                Toast.makeText(this, "Traversing Right", Toast.LENGTH_SHORT).show();
                //TODO add logic for text traversal
                break;
            case KEYBOARD_LEFT:
                Toast.makeText(this, "Traversing Left", Toast.LENGTH_SHORT).show();
                //TODO add logic for text traversal
                break;
            case KEYBOARD_CONFIRM:
                Toast.makeText(this, "Confirm Text", Toast.LENGTH_SHORT).show();
                //TODO add logic for confirming text
                break;
            case KEYBOARD_REJECT:
                Toast.makeText(this, "Reject Text", Toast.LENGTH_SHORT).show();
                //TODO add logic for rejecting text
                break;
            default:
                Log.d(Tags[0], "Invalid keycode");
        }
    }

    private void playClick(int i) {
        AudioManager am = (AudioManager) getSystemService(AUDIO_SERVICE);
        am.playSoundEffect(AudioManager.FX_KEY_CLICK);
    }

    @Override
    public void onText(CharSequence charSequence) {

    }

    @Override
    public void swipeLeft() {

    }

    @Override
    public void swipeRight() {

    }

    @Override
    public void swipeDown() {

    }

    @Override
    public void swipeUp() {

    }
}

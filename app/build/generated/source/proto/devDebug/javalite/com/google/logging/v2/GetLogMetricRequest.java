// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/logging/v2/logging_metrics.proto

package com.google.logging.v2;

/**
 * <pre>
 * The parameters to GetLogMetric.
 * </pre>
 *
 * Protobuf type {@code google.logging.v2.GetLogMetricRequest}
 */
public  final class GetLogMetricRequest extends
    com.google.protobuf.GeneratedMessageLite<
        GetLogMetricRequest, GetLogMetricRequest.Builder> implements
    // @@protoc_insertion_point(message_implements:google.logging.v2.GetLogMetricRequest)
    GetLogMetricRequestOrBuilder {
  private GetLogMetricRequest() {
    metricName_ = "";
  }
  public static final int METRIC_NAME_FIELD_NUMBER = 1;
  private java.lang.String metricName_;
  /**
   * <pre>
   * The resource name of the desired metric.
   * Example: `"projects/my-project-id/metrics/my-metric-id"`.
   * </pre>
   *
   * <code>optional string metric_name = 1;</code>
   */
  public java.lang.String getMetricName() {
    return metricName_;
  }
  /**
   * <pre>
   * The resource name of the desired metric.
   * Example: `"projects/my-project-id/metrics/my-metric-id"`.
   * </pre>
   *
   * <code>optional string metric_name = 1;</code>
   */
  public com.google.protobuf.ByteString
      getMetricNameBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(metricName_);
  }
  /**
   * <pre>
   * The resource name of the desired metric.
   * Example: `"projects/my-project-id/metrics/my-metric-id"`.
   * </pre>
   *
   * <code>optional string metric_name = 1;</code>
   */
  private void setMetricName(
      java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    metricName_ = value;
  }
  /**
   * <pre>
   * The resource name of the desired metric.
   * Example: `"projects/my-project-id/metrics/my-metric-id"`.
   * </pre>
   *
   * <code>optional string metric_name = 1;</code>
   */
  private void clearMetricName() {
    
    metricName_ = getDefaultInstance().getMetricName();
  }
  /**
   * <pre>
   * The resource name of the desired metric.
   * Example: `"projects/my-project-id/metrics/my-metric-id"`.
   * </pre>
   *
   * <code>optional string metric_name = 1;</code>
   */
  private void setMetricNameBytes(
      com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
    
    metricName_ = value.toStringUtf8();
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!metricName_.isEmpty()) {
      output.writeString(1, getMetricName());
    }
  }

  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    if (!metricName_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeStringSize(1, getMetricName());
    }
    memoizedSerializedSize = size;
    return size;
  }

  public static com.google.logging.v2.GetLogMetricRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static com.google.logging.v2.GetLogMetricRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static com.google.logging.v2.GetLogMetricRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static com.google.logging.v2.GetLogMetricRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static com.google.logging.v2.GetLogMetricRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static com.google.logging.v2.GetLogMetricRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static com.google.logging.v2.GetLogMetricRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static com.google.logging.v2.GetLogMetricRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static com.google.logging.v2.GetLogMetricRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static com.google.logging.v2.GetLogMetricRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.google.logging.v2.GetLogMetricRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /**
   * <pre>
   * The parameters to GetLogMetric.
   * </pre>
   *
   * Protobuf type {@code google.logging.v2.GetLogMetricRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        com.google.logging.v2.GetLogMetricRequest, Builder> implements
      // @@protoc_insertion_point(builder_implements:google.logging.v2.GetLogMetricRequest)
      com.google.logging.v2.GetLogMetricRequestOrBuilder {
    // Construct using com.google.logging.v2.GetLogMetricRequest.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <pre>
     * The resource name of the desired metric.
     * Example: `"projects/my-project-id/metrics/my-metric-id"`.
     * </pre>
     *
     * <code>optional string metric_name = 1;</code>
     */
    public java.lang.String getMetricName() {
      return instance.getMetricName();
    }
    /**
     * <pre>
     * The resource name of the desired metric.
     * Example: `"projects/my-project-id/metrics/my-metric-id"`.
     * </pre>
     *
     * <code>optional string metric_name = 1;</code>
     */
    public com.google.protobuf.ByteString
        getMetricNameBytes() {
      return instance.getMetricNameBytes();
    }
    /**
     * <pre>
     * The resource name of the desired metric.
     * Example: `"projects/my-project-id/metrics/my-metric-id"`.
     * </pre>
     *
     * <code>optional string metric_name = 1;</code>
     */
    public Builder setMetricName(
        java.lang.String value) {
      copyOnWrite();
      instance.setMetricName(value);
      return this;
    }
    /**
     * <pre>
     * The resource name of the desired metric.
     * Example: `"projects/my-project-id/metrics/my-metric-id"`.
     * </pre>
     *
     * <code>optional string metric_name = 1;</code>
     */
    public Builder clearMetricName() {
      copyOnWrite();
      instance.clearMetricName();
      return this;
    }
    /**
     * <pre>
     * The resource name of the desired metric.
     * Example: `"projects/my-project-id/metrics/my-metric-id"`.
     * </pre>
     *
     * <code>optional string metric_name = 1;</code>
     */
    public Builder setMetricNameBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setMetricNameBytes(value);
      return this;
    }

    // @@protoc_insertion_point(builder_scope:google.logging.v2.GetLogMetricRequest)
  }
  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new com.google.logging.v2.GetLogMetricRequest();
      }
      case IS_INITIALIZED: {
        return DEFAULT_INSTANCE;
      }
      case MAKE_IMMUTABLE: {
        return null;
      }
      case NEW_BUILDER: {
        return new Builder();
      }
      case VISIT: {
        Visitor visitor = (Visitor) arg0;
        com.google.logging.v2.GetLogMetricRequest other = (com.google.logging.v2.GetLogMetricRequest) arg1;
        metricName_ = visitor.visitString(!metricName_.isEmpty(), metricName_,
            !other.metricName_.isEmpty(), other.metricName_);
        if (visitor == com.google.protobuf.GeneratedMessageLite.MergeFromVisitor
            .INSTANCE) {
        }
        return this;
      }
      case MERGE_FROM_STREAM: {
        com.google.protobuf.CodedInputStream input =
            (com.google.protobuf.CodedInputStream) arg0;
        com.google.protobuf.ExtensionRegistryLite extensionRegistry =
            (com.google.protobuf.ExtensionRegistryLite) arg1;
        try {
          boolean done = false;
          while (!done) {
            int tag = input.readTag();
            switch (tag) {
              case 0:
                done = true;
                break;
              default: {
                if (!input.skipField(tag)) {
                  done = true;
                }
                break;
              }
              case 10: {
                String s = input.readStringRequireUtf8();

                metricName_ = s;
                break;
              }
            }
          }
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          throw new RuntimeException(e.setUnfinishedMessage(this));
        } catch (java.io.IOException e) {
          throw new RuntimeException(
              new com.google.protobuf.InvalidProtocolBufferException(
                  e.getMessage()).setUnfinishedMessage(this));
        } finally {
        }
      }
      case GET_DEFAULT_INSTANCE: {
        return DEFAULT_INSTANCE;
      }
      case GET_PARSER: {
        if (PARSER == null) {    synchronized (com.google.logging.v2.GetLogMetricRequest.class) {
            if (PARSER == null) {
              PARSER = new DefaultInstanceBasedParser(DEFAULT_INSTANCE);
            }
          }
        }
        return PARSER;
      }
    }
    throw new UnsupportedOperationException();
  }


  // @@protoc_insertion_point(class_scope:google.logging.v2.GetLogMetricRequest)
  private static final com.google.logging.v2.GetLogMetricRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new GetLogMetricRequest();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static com.google.logging.v2.GetLogMetricRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<GetLogMetricRequest> PARSER;

  public static com.google.protobuf.Parser<GetLogMetricRequest> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}


// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/logging/v2/log_entry.proto

package com.google.logging.v2;

public interface LogEntryOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.logging.v2.LogEntry)
    com.google.protobuf.MessageLiteOrBuilder {

  /**
   * <pre>
   * Required. The resource name of the log to which this log entry
   * belongs. The format of the name is
   * `projects/&amp;lt;project-id&amp;gt;/logs/&amp;lt;log-id%gt;`.  Examples:
   * `"projects/my-projectid/logs/syslog"`,
   * `"projects/1234567890/logs/library.googleapis.com%2Fbook_log"`.
   * The log ID part of resource name must be less than 512 characters
   * long and can only include the following characters: upper and
   * lower case alphanumeric characters: [A-Za-z0-9]; and punctuation
   * characters: forward-slash, underscore, hyphen, and period.
   * Forward-slash (`/`) characters in the log ID must be URL-encoded.
   * </pre>
   *
   * <code>optional string log_name = 12;</code>
   */
  java.lang.String getLogName();
  /**
   * <pre>
   * Required. The resource name of the log to which this log entry
   * belongs. The format of the name is
   * `projects/&amp;lt;project-id&amp;gt;/logs/&amp;lt;log-id%gt;`.  Examples:
   * `"projects/my-projectid/logs/syslog"`,
   * `"projects/1234567890/logs/library.googleapis.com%2Fbook_log"`.
   * The log ID part of resource name must be less than 512 characters
   * long and can only include the following characters: upper and
   * lower case alphanumeric characters: [A-Za-z0-9]; and punctuation
   * characters: forward-slash, underscore, hyphen, and period.
   * Forward-slash (`/`) characters in the log ID must be URL-encoded.
   * </pre>
   *
   * <code>optional string log_name = 12;</code>
   */
  com.google.protobuf.ByteString
      getLogNameBytes();

  /**
   * <pre>
   * Required. The monitored resource associated with this log entry.
   * Example: a log entry that reports a database error would be
   * associated with the monitored resource designating the particular
   * database that reported the error.
   * </pre>
   *
   * <code>optional .google.api.MonitoredResource resource = 8;</code>
   */
  boolean hasResource();
  /**
   * <pre>
   * Required. The monitored resource associated with this log entry.
   * Example: a log entry that reports a database error would be
   * associated with the monitored resource designating the particular
   * database that reported the error.
   * </pre>
   *
   * <code>optional .google.api.MonitoredResource resource = 8;</code>
   */
  com.google.api.MonitoredResource getResource();

  /**
   * <pre>
   * The log entry payload, represented as a protocol buffer.
   * You can only use `protoPayload` values that belong to a set of approved
   * types.
   * </pre>
   *
   * <code>optional .google.protobuf.Any proto_payload = 2;</code>
   */
  com.google.protobuf.Any getProtoPayload();

  /**
   * <pre>
   * The log entry payload, represented as a Unicode string (UTF-8).
   * </pre>
   *
   * <code>optional string text_payload = 3;</code>
   */
  java.lang.String getTextPayload();
  /**
   * <pre>
   * The log entry payload, represented as a Unicode string (UTF-8).
   * </pre>
   *
   * <code>optional string text_payload = 3;</code>
   */
  com.google.protobuf.ByteString
      getTextPayloadBytes();

  /**
   * <pre>
   * The log entry payload, represented as a structure that
   * is expressed as a JSON object.
   * </pre>
   *
   * <code>optional .google.protobuf.Struct json_payload = 6;</code>
   */
  com.google.protobuf.Struct getJsonPayload();

  /**
   * <pre>
   * Optional. The time the event described by the log entry occurred.  If
   * omitted, Cloud Logging will use the time the log entry is written.
   * </pre>
   *
   * <code>optional .google.protobuf.Timestamp timestamp = 9;</code>
   */
  boolean hasTimestamp();
  /**
   * <pre>
   * Optional. The time the event described by the log entry occurred.  If
   * omitted, Cloud Logging will use the time the log entry is written.
   * </pre>
   *
   * <code>optional .google.protobuf.Timestamp timestamp = 9;</code>
   */
  com.google.protobuf.Timestamp getTimestamp();

  /**
   * <pre>
   * Optional. The severity of the log entry. The default value is
   * `LogSeverity.DEFAULT`.
   * </pre>
   *
   * <code>optional .google.logging.type.LogSeverity severity = 10;</code>
   */
  int getSeverityValue();
  /**
   * <pre>
   * Optional. The severity of the log entry. The default value is
   * `LogSeverity.DEFAULT`.
   * </pre>
   *
   * <code>optional .google.logging.type.LogSeverity severity = 10;</code>
   */
  com.google.logging.type.LogSeverity getSeverity();

  /**
   * <pre>
   * Optional. A unique ID for the log entry. If you provide this field, the
   * logging service considers other log entries in the same log with the same
   * ID as duplicates which can be removed.
   * If omitted, Cloud Logging will generate a unique ID for this log entry.
   * </pre>
   *
   * <code>optional string insert_id = 4;</code>
   */
  java.lang.String getInsertId();
  /**
   * <pre>
   * Optional. A unique ID for the log entry. If you provide this field, the
   * logging service considers other log entries in the same log with the same
   * ID as duplicates which can be removed.
   * If omitted, Cloud Logging will generate a unique ID for this log entry.
   * </pre>
   *
   * <code>optional string insert_id = 4;</code>
   */
  com.google.protobuf.ByteString
      getInsertIdBytes();

  /**
   * <pre>
   * Optional. Information about the HTTP request associated with this log entry,
   * if applicable.
   * </pre>
   *
   * <code>optional .google.logging.type.HttpRequest http_request = 7;</code>
   */
  boolean hasHttpRequest();
  /**
   * <pre>
   * Optional. Information about the HTTP request associated with this log entry,
   * if applicable.
   * </pre>
   *
   * <code>optional .google.logging.type.HttpRequest http_request = 7;</code>
   */
  com.google.logging.type.HttpRequest getHttpRequest();

  /**
   * <pre>
   * Optional. A set of user-defined (key, value) data that provides additional
   * information about the log entry.
   * </pre>
   *
   * <code>map&lt;string, string&gt; labels = 11;</code>
   */
  int getLabelsCount();
  /**
   * <pre>
   * Optional. A set of user-defined (key, value) data that provides additional
   * information about the log entry.
   * </pre>
   *
   * <code>map&lt;string, string&gt; labels = 11;</code>
   */
  boolean containsLabels(
      java.lang.String key);
  /**
   * Use {@link #getLabelsMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.String, java.lang.String>
  getLabels();
  /**
   * <pre>
   * Optional. A set of user-defined (key, value) data that provides additional
   * information about the log entry.
   * </pre>
   *
   * <code>map&lt;string, string&gt; labels = 11;</code>
   */
  java.util.Map<java.lang.String, java.lang.String>
  getLabelsMap();
  /**
   * <pre>
   * Optional. A set of user-defined (key, value) data that provides additional
   * information about the log entry.
   * </pre>
   *
   * <code>map&lt;string, string&gt; labels = 11;</code>
   */

  java.lang.String getLabelsOrDefault(
      java.lang.String key,
      java.lang.String defaultValue);
  /**
   * <pre>
   * Optional. A set of user-defined (key, value) data that provides additional
   * information about the log entry.
   * </pre>
   *
   * <code>map&lt;string, string&gt; labels = 11;</code>
   */

  java.lang.String getLabelsOrThrow(
      java.lang.String key);

  /**
   * <pre>
   * Optional. Information about an operation associated with the log entry, if
   * applicable.
   * </pre>
   *
   * <code>optional .google.logging.v2.LogEntryOperation operation = 15;</code>
   */
  boolean hasOperation();
  /**
   * <pre>
   * Optional. Information about an operation associated with the log entry, if
   * applicable.
   * </pre>
   *
   * <code>optional .google.logging.v2.LogEntryOperation operation = 15;</code>
   */
  com.google.logging.v2.LogEntryOperation getOperation();

  public com.google.logging.v2.LogEntry.PayloadCase getPayloadCase();
}

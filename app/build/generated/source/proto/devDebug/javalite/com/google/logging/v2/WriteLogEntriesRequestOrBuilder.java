// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/logging/v2/logging.proto

package com.google.logging.v2;

public interface WriteLogEntriesRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.logging.v2.WriteLogEntriesRequest)
    com.google.protobuf.MessageLiteOrBuilder {

  /**
   * <pre>
   * Optional. A default log resource name for those log entries in `entries`
   * that do not specify their own `logName`.  Example:
   * `"projects/my-project/logs/syslog"`.  See
   * [LogEntry][google.logging.v2.LogEntry].
   * </pre>
   *
   * <code>optional string log_name = 1;</code>
   */
  java.lang.String getLogName();
  /**
   * <pre>
   * Optional. A default log resource name for those log entries in `entries`
   * that do not specify their own `logName`.  Example:
   * `"projects/my-project/logs/syslog"`.  See
   * [LogEntry][google.logging.v2.LogEntry].
   * </pre>
   *
   * <code>optional string log_name = 1;</code>
   */
  com.google.protobuf.ByteString
      getLogNameBytes();

  /**
   * <pre>
   * Optional. A default monitored resource for those log entries in `entries`
   * that do not specify their own `resource`.
   * </pre>
   *
   * <code>optional .google.api.MonitoredResource resource = 2;</code>
   */
  boolean hasResource();
  /**
   * <pre>
   * Optional. A default monitored resource for those log entries in `entries`
   * that do not specify their own `resource`.
   * </pre>
   *
   * <code>optional .google.api.MonitoredResource resource = 2;</code>
   */
  com.google.api.MonitoredResource getResource();

  /**
   * <pre>
   * Optional. User-defined `key:value` items that are added to
   * the `labels` field of each log entry in `entries`, except when a log
   * entry specifies its own `key:value` item with the same key.
   * Example: `{ "size": "large", "color":"red" }`
   * </pre>
   *
   * <code>map&lt;string, string&gt; labels = 3;</code>
   */
  int getLabelsCount();
  /**
   * <pre>
   * Optional. User-defined `key:value` items that are added to
   * the `labels` field of each log entry in `entries`, except when a log
   * entry specifies its own `key:value` item with the same key.
   * Example: `{ "size": "large", "color":"red" }`
   * </pre>
   *
   * <code>map&lt;string, string&gt; labels = 3;</code>
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
   * Optional. User-defined `key:value` items that are added to
   * the `labels` field of each log entry in `entries`, except when a log
   * entry specifies its own `key:value` item with the same key.
   * Example: `{ "size": "large", "color":"red" }`
   * </pre>
   *
   * <code>map&lt;string, string&gt; labels = 3;</code>
   */
  java.util.Map<java.lang.String, java.lang.String>
  getLabelsMap();
  /**
   * <pre>
   * Optional. User-defined `key:value` items that are added to
   * the `labels` field of each log entry in `entries`, except when a log
   * entry specifies its own `key:value` item with the same key.
   * Example: `{ "size": "large", "color":"red" }`
   * </pre>
   *
   * <code>map&lt;string, string&gt; labels = 3;</code>
   */

  java.lang.String getLabelsOrDefault(
      java.lang.String key,
      java.lang.String defaultValue);
  /**
   * <pre>
   * Optional. User-defined `key:value` items that are added to
   * the `labels` field of each log entry in `entries`, except when a log
   * entry specifies its own `key:value` item with the same key.
   * Example: `{ "size": "large", "color":"red" }`
   * </pre>
   *
   * <code>map&lt;string, string&gt; labels = 3;</code>
   */

  java.lang.String getLabelsOrThrow(
      java.lang.String key);

  /**
   * <pre>
   * Required. The log entries to write. The log entries must have values for
   * all required fields.
   * </pre>
   *
   * <code>repeated .google.logging.v2.LogEntry entries = 4;</code>
   */
  java.util.List<com.google.logging.v2.LogEntry> 
      getEntriesList();
  /**
   * <pre>
   * Required. The log entries to write. The log entries must have values for
   * all required fields.
   * </pre>
   *
   * <code>repeated .google.logging.v2.LogEntry entries = 4;</code>
   */
  com.google.logging.v2.LogEntry getEntries(int index);
  /**
   * <pre>
   * Required. The log entries to write. The log entries must have values for
   * all required fields.
   * </pre>
   *
   * <code>repeated .google.logging.v2.LogEntry entries = 4;</code>
   */
  int getEntriesCount();
}
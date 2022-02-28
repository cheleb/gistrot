package libgit

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import scalanative.libc.*

object predef:
  abstract class CEnum[T](using eq: T =:= Int):
    given Tag[T] = Tag.Int.asInstanceOf[Tag[T]]
    extension (t: T) def int: CInt = eq.apply(t)

  abstract class CEnumU[T](using eq: T =:= UInt):
    given Tag[T] = Tag.UInt.asInstanceOf[Tag[T]]
    extension (t: T)
      def int: CInt = eq.apply(t).toInt
      def uint: CUnsignedInt = eq.apply(t)

object types:
  import predef.*
  opaque type git_apply_flags_t = CUnsignedInt
  object git_apply_flags_t extends CEnumU[git_apply_flags_t]:
    given _tag: Tag[git_apply_flags_t] = Tag.UInt
    inline def define(inline a: Long): git_apply_flags_t = a.toUInt
    val GIT_APPLY_CHECK = define(1)

  opaque type git_apply_location_t = CUnsignedInt
  object git_apply_location_t extends CEnumU[git_apply_location_t]:
    given _tag: Tag[git_apply_location_t] = Tag.UInt
    inline def define(inline a: Long): git_apply_location_t = a.toUInt
    val GIT_APPLY_LOCATION_WORKDIR = define(0)
    val GIT_APPLY_LOCATION_INDEX = define(1)
    val GIT_APPLY_LOCATION_BOTH = define(2)

  opaque type git_attr_value_t = CUnsignedInt
  object git_attr_value_t extends CEnumU[git_attr_value_t]:
    given _tag: Tag[git_attr_value_t] = Tag.UInt
    inline def define(inline a: Long): git_attr_value_t = a.toUInt
    val GIT_ATTR_VALUE_UNSPECIFIED = define(0)
    val GIT_ATTR_VALUE_TRUE = define(1)
    val GIT_ATTR_VALUE_FALSE = define(2)
    val GIT_ATTR_VALUE_STRING = define(3)

  opaque type git_blame_flag_t = CUnsignedInt
  object git_blame_flag_t extends CEnumU[git_blame_flag_t]:
    given _tag: Tag[git_blame_flag_t] = Tag.UInt
    inline def define(inline a: Long): git_blame_flag_t = a.toUInt
    val GIT_BLAME_NORMAL = define(0)
    val GIT_BLAME_TRACK_COPIES_SAME_FILE = define(1)
    val GIT_BLAME_TRACK_COPIES_SAME_COMMIT_MOVES = define(2)
    val GIT_BLAME_TRACK_COPIES_SAME_COMMIT_COPIES = define(4)
    val GIT_BLAME_TRACK_COPIES_ANY_COMMIT_COPIES = define(8)
    val GIT_BLAME_FIRST_PARENT = define(16)
    val GIT_BLAME_USE_MAILMAP = define(32)
    val GIT_BLAME_IGNORE_WHITESPACE = define(64)

  opaque type git_blob_filter_flag_t = CUnsignedInt
  object git_blob_filter_flag_t extends CEnumU[git_blob_filter_flag_t]:
    given _tag: Tag[git_blob_filter_flag_t] = Tag.UInt
    inline def define(inline a: Long): git_blob_filter_flag_t = a.toUInt
    val GIT_BLOB_FILTER_CHECK_FOR_BINARY = define(1)
    val GIT_BLOB_FILTER_NO_SYSTEM_ATTRIBUTES = define(2)
    val GIT_BLOB_FILTER_ATTRIBUTES_FROM_HEAD = define(4)
    val GIT_BLOB_FILTER_ATTRIBUTES_FROM_COMMIT = define(8)

  opaque type git_branch_t = CUnsignedInt
  object git_branch_t extends CEnumU[git_branch_t]:
    given _tag: Tag[git_branch_t] = Tag.UInt
    inline def define(inline a: Long): git_branch_t = a.toUInt
    val GIT_BRANCH_LOCAL = define(1)
    val GIT_BRANCH_REMOTE = define(2)
    val GIT_BRANCH_ALL = define(3)

  opaque type git_cert_ssh_raw_type_t = CUnsignedInt
  object git_cert_ssh_raw_type_t extends CEnumU[git_cert_ssh_raw_type_t]:
    given _tag: Tag[git_cert_ssh_raw_type_t] = Tag.UInt
    inline def define(inline a: Long): git_cert_ssh_raw_type_t = a.toUInt
    val GIT_CERT_SSH_RAW_TYPE_UNKNOWN = define(0)
    val GIT_CERT_SSH_RAW_TYPE_RSA = define(1)
    val GIT_CERT_SSH_RAW_TYPE_DSS = define(2)
    val GIT_CERT_SSH_RAW_TYPE_KEY_ECDSA_256 = define(3)
    val GIT_CERT_SSH_RAW_TYPE_KEY_ECDSA_384 = define(4)
    val GIT_CERT_SSH_RAW_TYPE_KEY_ECDSA_521 = define(5)
    val GIT_CERT_SSH_RAW_TYPE_KEY_ED25519 = define(6)

  opaque type git_cert_ssh_t = CUnsignedInt
  object git_cert_ssh_t extends CEnumU[git_cert_ssh_t]:
    given _tag: Tag[git_cert_ssh_t] = Tag.UInt
    inline def define(inline a: Long): git_cert_ssh_t = a.toUInt
    val GIT_CERT_SSH_MD5 = define(1)
    val GIT_CERT_SSH_SHA1 = define(2)
    val GIT_CERT_SSH_SHA256 = define(4)
    val GIT_CERT_SSH_RAW = define(8)

  opaque type git_cert_t = CUnsignedInt
  object git_cert_t extends CEnumU[git_cert_t]:
    given _tag: Tag[git_cert_t] = Tag.UInt
    inline def define(inline a: Long): git_cert_t = a.toUInt
    val GIT_CERT_NONE = define(0)
    val GIT_CERT_X509 = define(1)
    val GIT_CERT_HOSTKEY_LIBSSH2 = define(2)
    val GIT_CERT_STRARRAY = define(3)

  opaque type git_checkout_notify_t = CUnsignedInt
  object git_checkout_notify_t extends CEnumU[git_checkout_notify_t]:
    given _tag: Tag[git_checkout_notify_t] = Tag.UInt
    inline def define(inline a: Long): git_checkout_notify_t = a.toUInt
    val GIT_CHECKOUT_NOTIFY_NONE = define(0)
    val GIT_CHECKOUT_NOTIFY_CONFLICT = define(1)
    val GIT_CHECKOUT_NOTIFY_DIRTY = define(2)
    val GIT_CHECKOUT_NOTIFY_UPDATED = define(4)
    val GIT_CHECKOUT_NOTIFY_UNTRACKED = define(8)
    val GIT_CHECKOUT_NOTIFY_IGNORED = define(16)
    val GIT_CHECKOUT_NOTIFY_ALL = define(65535)

  opaque type git_checkout_strategy_t = CUnsignedInt
  object git_checkout_strategy_t extends CEnumU[git_checkout_strategy_t]:
    given _tag: Tag[git_checkout_strategy_t] = Tag.UInt
    inline def define(inline a: Long): git_checkout_strategy_t = a.toUInt
    val GIT_CHECKOUT_NONE = define(0)
    val GIT_CHECKOUT_SAFE = define(1)
    val GIT_CHECKOUT_FORCE = define(2)
    val GIT_CHECKOUT_RECREATE_MISSING = define(4)
    val GIT_CHECKOUT_ALLOW_CONFLICTS = define(16)
    val GIT_CHECKOUT_REMOVE_UNTRACKED = define(32)
    val GIT_CHECKOUT_REMOVE_IGNORED = define(64)
    val GIT_CHECKOUT_UPDATE_ONLY = define(128)
    val GIT_CHECKOUT_DONT_UPDATE_INDEX = define(256)
    val GIT_CHECKOUT_NO_REFRESH = define(512)
    val GIT_CHECKOUT_SKIP_UNMERGED = define(1024)
    val GIT_CHECKOUT_USE_OURS = define(2048)
    val GIT_CHECKOUT_USE_THEIRS = define(4096)
    val GIT_CHECKOUT_DISABLE_PATHSPEC_MATCH = define(8192)
    val GIT_CHECKOUT_SKIP_LOCKED_DIRECTORIES = define(262144)
    val GIT_CHECKOUT_DONT_OVERWRITE_IGNORED = define(524288)
    val GIT_CHECKOUT_CONFLICT_STYLE_MERGE = define(1048576)
    val GIT_CHECKOUT_CONFLICT_STYLE_DIFF3 = define(2097152)
    val GIT_CHECKOUT_DONT_REMOVE_EXISTING = define(4194304)
    val GIT_CHECKOUT_DONT_WRITE_INDEX = define(8388608)
    val GIT_CHECKOUT_DRY_RUN = define(16777216)
    val GIT_CHECKOUT_CONFLICT_STYLE_ZDIFF3 = define(33554432)
    val GIT_CHECKOUT_UPDATE_SUBMODULES = define(65536)
    val GIT_CHECKOUT_UPDATE_SUBMODULES_IF_CHANGED = define(131072)

  opaque type git_clone_local_t = CUnsignedInt
  object git_clone_local_t extends CEnumU[git_clone_local_t]:
    given _tag: Tag[git_clone_local_t] = Tag.UInt
    inline def define(inline a: Long): git_clone_local_t = a.toUInt
    val GIT_CLONE_LOCAL_AUTO = define(0)
    val GIT_CLONE_LOCAL = define(1)
    val GIT_CLONE_NO_LOCAL = define(2)
    val GIT_CLONE_LOCAL_NO_LINKS = define(3)

  opaque type git_config_level_t = CInt
  object git_config_level_t extends CEnum[git_config_level_t]:
    given _tag: Tag[git_config_level_t] = Tag.Int
    inline def define(inline a: CInt): git_config_level_t = a
    val GIT_CONFIG_LEVEL_PROGRAMDATA = define(1)
    val GIT_CONFIG_LEVEL_SYSTEM = define(2)
    val GIT_CONFIG_LEVEL_XDG = define(3)
    val GIT_CONFIG_LEVEL_GLOBAL = define(4)
    val GIT_CONFIG_LEVEL_LOCAL = define(5)
    val GIT_CONFIG_LEVEL_APP = define(6)
    val GIT_CONFIG_HIGHEST_LEVEL = define(-1)

  opaque type git_configmap_t = CUnsignedInt
  object git_configmap_t extends CEnumU[git_configmap_t]:
    given _tag: Tag[git_configmap_t] = Tag.UInt
    inline def define(inline a: Long): git_configmap_t = a.toUInt
    val GIT_CONFIGMAP_FALSE = define(0)
    val GIT_CONFIGMAP_TRUE = define(1)
    val GIT_CONFIGMAP_INT32 = define(2)
    val GIT_CONFIGMAP_STRING = define(3)

  opaque type git_credential_t = CUnsignedInt
  object git_credential_t extends CEnumU[git_credential_t]:
    given _tag: Tag[git_credential_t] = Tag.UInt
    inline def define(inline a: Long): git_credential_t = a.toUInt
    val GIT_CREDENTIAL_USERPASS_PLAINTEXT = define(1)
    val GIT_CREDENTIAL_SSH_KEY = define(2)
    val GIT_CREDENTIAL_SSH_CUSTOM = define(4)
    val GIT_CREDENTIAL_DEFAULT = define(8)
    val GIT_CREDENTIAL_SSH_INTERACTIVE = define(16)
    val GIT_CREDENTIAL_USERNAME = define(32)
    val GIT_CREDENTIAL_SSH_MEMORY = define(64)

  opaque type git_delta_t = CUnsignedInt
  object git_delta_t extends CEnumU[git_delta_t]:
    given _tag: Tag[git_delta_t] = Tag.UInt
    inline def define(inline a: Long): git_delta_t = a.toUInt
    val GIT_DELTA_UNMODIFIED = define(0)
    val GIT_DELTA_ADDED = define(1)
    val GIT_DELTA_DELETED = define(2)
    val GIT_DELTA_MODIFIED = define(3)
    val GIT_DELTA_RENAMED = define(4)
    val GIT_DELTA_COPIED = define(5)
    val GIT_DELTA_IGNORED = define(6)
    val GIT_DELTA_UNTRACKED = define(7)
    val GIT_DELTA_TYPECHANGE = define(8)
    val GIT_DELTA_UNREADABLE = define(9)
    val GIT_DELTA_CONFLICTED = define(10)

  opaque type git_describe_strategy_t = CUnsignedInt
  object git_describe_strategy_t extends CEnumU[git_describe_strategy_t]:
    given _tag: Tag[git_describe_strategy_t] = Tag.UInt
    inline def define(inline a: Long): git_describe_strategy_t = a.toUInt
    val GIT_DESCRIBE_DEFAULT = define(0)
    val GIT_DESCRIBE_TAGS = define(1)
    val GIT_DESCRIBE_ALL = define(2)

  opaque type git_diff_binary_t = CUnsignedInt
  object git_diff_binary_t extends CEnumU[git_diff_binary_t]:
    given _tag: Tag[git_diff_binary_t] = Tag.UInt
    inline def define(inline a: Long): git_diff_binary_t = a.toUInt
    val GIT_DIFF_BINARY_NONE = define(0)
    val GIT_DIFF_BINARY_LITERAL = define(1)
    val GIT_DIFF_BINARY_DELTA = define(2)

  opaque type git_diff_find_t = CUnsignedInt
  object git_diff_find_t extends CEnumU[git_diff_find_t]:
    given _tag: Tag[git_diff_find_t] = Tag.UInt
    inline def define(inline a: Long): git_diff_find_t = a.toUInt
    val GIT_DIFF_FIND_BY_CONFIG = define(0)
    val GIT_DIFF_FIND_RENAMES = define(1)
    val GIT_DIFF_FIND_RENAMES_FROM_REWRITES = define(2)
    val GIT_DIFF_FIND_COPIES = define(4)
    val GIT_DIFF_FIND_COPIES_FROM_UNMODIFIED = define(8)
    val GIT_DIFF_FIND_REWRITES = define(16)
    val GIT_DIFF_BREAK_REWRITES = define(32)
    val GIT_DIFF_FIND_AND_BREAK_REWRITES = define(48)
    val GIT_DIFF_FIND_FOR_UNTRACKED = define(64)
    val GIT_DIFF_FIND_ALL = define(255)
    val GIT_DIFF_FIND_IGNORE_LEADING_WHITESPACE = define(0)
    val GIT_DIFF_FIND_IGNORE_WHITESPACE = define(4096)
    val GIT_DIFF_FIND_DONT_IGNORE_WHITESPACE = define(8192)
    val GIT_DIFF_FIND_EXACT_MATCH_ONLY = define(16384)
    val GIT_DIFF_BREAK_REWRITES_FOR_RENAMES_ONLY = define(32768)
    val GIT_DIFF_FIND_REMOVE_UNMODIFIED = define(65536)

  opaque type git_diff_flag_t = CUnsignedInt
  object git_diff_flag_t extends CEnumU[git_diff_flag_t]:
    given _tag: Tag[git_diff_flag_t] = Tag.UInt
    inline def define(inline a: Long): git_diff_flag_t = a.toUInt
    val GIT_DIFF_FLAG_BINARY = define(1)
    val GIT_DIFF_FLAG_NOT_BINARY = define(2)
    val GIT_DIFF_FLAG_VALID_ID = define(4)
    val GIT_DIFF_FLAG_EXISTS = define(8)
    val GIT_DIFF_FLAG_VALID_SIZE = define(16)

  opaque type git_diff_format_email_flags_t = CUnsignedInt
  object git_diff_format_email_flags_t
      extends CEnumU[git_diff_format_email_flags_t]:
    given _tag: Tag[git_diff_format_email_flags_t] = Tag.UInt
    inline def define(inline a: Long): git_diff_format_email_flags_t = a.toUInt
    val GIT_DIFF_FORMAT_EMAIL_NONE = define(0)
    val GIT_DIFF_FORMAT_EMAIL_EXCLUDE_SUBJECT_PATCH_MARKER = define(1)

  opaque type git_diff_format_t = CUnsignedInt
  object git_diff_format_t extends CEnumU[git_diff_format_t]:
    given _tag: Tag[git_diff_format_t] = Tag.UInt
    inline def define(inline a: Long): git_diff_format_t = a.toUInt
    val GIT_DIFF_FORMAT_PATCH = define(1)
    val GIT_DIFF_FORMAT_PATCH_HEADER = define(2)
    val GIT_DIFF_FORMAT_RAW = define(3)
    val GIT_DIFF_FORMAT_NAME_ONLY = define(4)
    val GIT_DIFF_FORMAT_NAME_STATUS = define(5)
    val GIT_DIFF_FORMAT_PATCH_ID = define(6)

  opaque type git_diff_line_t = CUnsignedInt
  object git_diff_line_t extends CEnumU[git_diff_line_t]:
    given _tag: Tag[git_diff_line_t] = Tag.UInt
    inline def define(inline a: Long): git_diff_line_t = a.toUInt
    val GIT_DIFF_LINE_CONTEXT = define(32)
    val GIT_DIFF_LINE_ADDITION = define(43)
    val GIT_DIFF_LINE_DELETION = define(45)
    val GIT_DIFF_LINE_CONTEXT_EOFNL = define(61)
    val GIT_DIFF_LINE_ADD_EOFNL = define(62)
    val GIT_DIFF_LINE_DEL_EOFNL = define(60)
    val GIT_DIFF_LINE_FILE_HDR = define(70)
    val GIT_DIFF_LINE_HUNK_HDR = define(72)
    val GIT_DIFF_LINE_BINARY = define(66)

  opaque type git_diff_option_t = CUnsignedInt
  object git_diff_option_t extends CEnumU[git_diff_option_t]:
    given _tag: Tag[git_diff_option_t] = Tag.UInt
    inline def define(inline a: Long): git_diff_option_t = a.toUInt
    val GIT_DIFF_NORMAL = define(0)
    val GIT_DIFF_REVERSE = define(1)
    val GIT_DIFF_INCLUDE_IGNORED = define(2)
    val GIT_DIFF_RECURSE_IGNORED_DIRS = define(4)
    val GIT_DIFF_INCLUDE_UNTRACKED = define(8)
    val GIT_DIFF_RECURSE_UNTRACKED_DIRS = define(16)
    val GIT_DIFF_INCLUDE_UNMODIFIED = define(32)
    val GIT_DIFF_INCLUDE_TYPECHANGE = define(64)
    val GIT_DIFF_INCLUDE_TYPECHANGE_TREES = define(128)
    val GIT_DIFF_IGNORE_FILEMODE = define(256)
    val GIT_DIFF_IGNORE_SUBMODULES = define(512)
    val GIT_DIFF_IGNORE_CASE = define(1024)
    val GIT_DIFF_INCLUDE_CASECHANGE = define(2048)
    val GIT_DIFF_DISABLE_PATHSPEC_MATCH = define(4096)
    val GIT_DIFF_SKIP_BINARY_CHECK = define(8192)
    val GIT_DIFF_ENABLE_FAST_UNTRACKED_DIRS = define(16384)
    val GIT_DIFF_UPDATE_INDEX = define(32768)
    val GIT_DIFF_INCLUDE_UNREADABLE = define(65536)
    val GIT_DIFF_INCLUDE_UNREADABLE_AS_UNTRACKED = define(131072)
    val GIT_DIFF_INDENT_HEURISTIC = define(262144)
    val GIT_DIFF_IGNORE_BLANK_LINES = define(524288)
    val GIT_DIFF_FORCE_TEXT = define(1048576)
    val GIT_DIFF_FORCE_BINARY = define(2097152)
    val GIT_DIFF_IGNORE_WHITESPACE = define(4194304)
    val GIT_DIFF_IGNORE_WHITESPACE_CHANGE = define(8388608)
    val GIT_DIFF_IGNORE_WHITESPACE_EOL = define(16777216)
    val GIT_DIFF_SHOW_UNTRACKED_CONTENT = define(33554432)
    val GIT_DIFF_SHOW_UNMODIFIED = define(67108864)
    val GIT_DIFF_PATIENCE = define(268435456)
    val GIT_DIFF_MINIMAL = define(536870912)
    val GIT_DIFF_SHOW_BINARY = define(1073741824)

  opaque type git_diff_stats_format_t = CUnsignedInt
  object git_diff_stats_format_t extends CEnumU[git_diff_stats_format_t]:
    given _tag: Tag[git_diff_stats_format_t] = Tag.UInt
    inline def define(inline a: Long): git_diff_stats_format_t = a.toUInt
    val GIT_DIFF_STATS_NONE = define(0)
    val GIT_DIFF_STATS_FULL = define(1)
    val GIT_DIFF_STATS_SHORT = define(2)
    val GIT_DIFF_STATS_NUMBER = define(4)
    val GIT_DIFF_STATS_INCLUDE_SUMMARY = define(8)

  opaque type git_direction = CUnsignedInt
  object git_direction extends CEnumU[git_direction]:
    given _tag: Tag[git_direction] = Tag.UInt
    inline def define(inline a: Long): git_direction = a.toUInt
    val GIT_DIRECTION_FETCH = define(0)
    val GIT_DIRECTION_PUSH = define(1)

  opaque type git_email_create_flags_t = CUnsignedInt
  object git_email_create_flags_t extends CEnumU[git_email_create_flags_t]:
    given _tag: Tag[git_email_create_flags_t] = Tag.UInt
    inline def define(inline a: Long): git_email_create_flags_t = a.toUInt
    val GIT_EMAIL_CREATE_DEFAULT = define(0)
    val GIT_EMAIL_CREATE_OMIT_NUMBERS = define(1)
    val GIT_EMAIL_CREATE_ALWAYS_NUMBER = define(2)
    val GIT_EMAIL_CREATE_NO_RENAMES = define(4)

  opaque type git_error_code = CInt
  object git_error_code extends CEnum[git_error_code]:
    given _tag: Tag[git_error_code] = Tag.Int
    inline def define(inline a: CInt): git_error_code = a
    val GIT_OK = define(0)
    val GIT_ERROR = define(-1)
    val GIT_ENOTFOUND = define(-3)
    val GIT_EEXISTS = define(-4)
    val GIT_EAMBIGUOUS = define(-5)
    val GIT_EBUFS = define(-6)
    val GIT_EUSER = define(-7)
    val GIT_EBAREREPO = define(-8)
    val GIT_EUNBORNBRANCH = define(-9)
    val GIT_EUNMERGED = define(-10)
    val GIT_ENONFASTFORWARD = define(-11)
    val GIT_EINVALIDSPEC = define(-12)
    val GIT_ECONFLICT = define(-13)
    val GIT_ELOCKED = define(-14)
    val GIT_EMODIFIED = define(-15)
    val GIT_EAUTH = define(-16)
    val GIT_ECERTIFICATE = define(-17)
    val GIT_EAPPLIED = define(-18)
    val GIT_EPEEL = define(-19)
    val GIT_EEOF = define(-20)
    val GIT_EINVALID = define(-21)
    val GIT_EUNCOMMITTED = define(-22)
    val GIT_EDIRECTORY = define(-23)
    val GIT_EMERGECONFLICT = define(-24)
    val GIT_PASSTHROUGH = define(-30)
    val GIT_ITEROVER = define(-31)
    val GIT_RETRY = define(-32)
    val GIT_EMISMATCH = define(-33)
    val GIT_EINDEXDIRTY = define(-34)
    val GIT_EAPPLYFAIL = define(-35)

  opaque type git_error_t = CUnsignedInt
  object git_error_t extends CEnumU[git_error_t]:
    given _tag: Tag[git_error_t] = Tag.UInt
    inline def define(inline a: Long): git_error_t = a.toUInt
    val GIT_ERROR_NONE = define(0)
    val GIT_ERROR_NOMEMORY = define(1)
    val GIT_ERROR_OS = define(2)
    val GIT_ERROR_INVALID = define(3)
    val GIT_ERROR_REFERENCE = define(4)
    val GIT_ERROR_ZLIB = define(5)
    val GIT_ERROR_REPOSITORY = define(6)
    val GIT_ERROR_CONFIG = define(7)
    val GIT_ERROR_REGEX = define(8)
    val GIT_ERROR_ODB = define(9)
    val GIT_ERROR_INDEX = define(10)
    val GIT_ERROR_OBJECT = define(11)
    val GIT_ERROR_NET = define(12)
    val GIT_ERROR_TAG = define(13)
    val GIT_ERROR_TREE = define(14)
    val GIT_ERROR_INDEXER = define(15)
    val GIT_ERROR_SSL = define(16)
    val GIT_ERROR_SUBMODULE = define(17)
    val GIT_ERROR_THREAD = define(18)
    val GIT_ERROR_STASH = define(19)
    val GIT_ERROR_CHECKOUT = define(20)
    val GIT_ERROR_FETCHHEAD = define(21)
    val GIT_ERROR_MERGE = define(22)
    val GIT_ERROR_SSH = define(23)
    val GIT_ERROR_FILTER = define(24)
    val GIT_ERROR_REVERT = define(25)
    val GIT_ERROR_CALLBACK = define(26)
    val GIT_ERROR_CHERRYPICK = define(27)
    val GIT_ERROR_DESCRIBE = define(28)
    val GIT_ERROR_REBASE = define(29)
    val GIT_ERROR_FILESYSTEM = define(30)
    val GIT_ERROR_PATCH = define(31)
    val GIT_ERROR_WORKTREE = define(32)
    val GIT_ERROR_SHA1 = define(33)
    val GIT_ERROR_HTTP = define(34)
    val GIT_ERROR_INTERNAL = define(35)

  opaque type git_feature_t = CUnsignedInt
  object git_feature_t extends CEnumU[git_feature_t]:
    given _tag: Tag[git_feature_t] = Tag.UInt
    inline def define(inline a: Long): git_feature_t = a.toUInt
    val GIT_FEATURE_THREADS = define(1)
    val GIT_FEATURE_HTTPS = define(2)
    val GIT_FEATURE_SSH = define(4)
    val GIT_FEATURE_NSEC = define(8)

  opaque type git_fetch_prune_t = CUnsignedInt
  object git_fetch_prune_t extends CEnumU[git_fetch_prune_t]:
    given _tag: Tag[git_fetch_prune_t] = Tag.UInt
    inline def define(inline a: Long): git_fetch_prune_t = a.toUInt
    val GIT_FETCH_PRUNE_UNSPECIFIED = define(0)
    val GIT_FETCH_PRUNE = define(1)
    val GIT_FETCH_NO_PRUNE = define(2)

  opaque type git_filemode_t = CUnsignedInt
  object git_filemode_t extends CEnumU[git_filemode_t]:
    given _tag: Tag[git_filemode_t] = Tag.UInt
    inline def define(inline a: Long): git_filemode_t = a.toUInt
    val GIT_FILEMODE_UNREADABLE = define(0)
    val GIT_FILEMODE_TREE = define(16384)
    val GIT_FILEMODE_BLOB = define(33188)
    val GIT_FILEMODE_BLOB_EXECUTABLE = define(33261)
    val GIT_FILEMODE_LINK = define(40960)
    val GIT_FILEMODE_COMMIT = define(57344)

  opaque type git_filter_flag_t = CUnsignedInt
  object git_filter_flag_t extends CEnumU[git_filter_flag_t]:
    given _tag: Tag[git_filter_flag_t] = Tag.UInt
    inline def define(inline a: Long): git_filter_flag_t = a.toUInt
    val GIT_FILTER_DEFAULT = define(0)
    val GIT_FILTER_ALLOW_UNSAFE = define(1)
    val GIT_FILTER_NO_SYSTEM_ATTRIBUTES = define(2)
    val GIT_FILTER_ATTRIBUTES_FROM_HEAD = define(4)
    val GIT_FILTER_ATTRIBUTES_FROM_COMMIT = define(8)

  opaque type git_filter_mode_t = CUnsignedInt
  object git_filter_mode_t extends CEnumU[git_filter_mode_t]:
    given _tag: Tag[git_filter_mode_t] = Tag.UInt
    inline def define(inline a: Long): git_filter_mode_t = a.toUInt
    val GIT_FILTER_TO_WORKTREE = define(0)
    val GIT_FILTER_SMUDGE = define(0)
    val GIT_FILTER_TO_ODB = define(1)
    val GIT_FILTER_CLEAN = define(1)

  opaque type git_index_add_option_t = CUnsignedInt
  object git_index_add_option_t extends CEnumU[git_index_add_option_t]:
    given _tag: Tag[git_index_add_option_t] = Tag.UInt
    inline def define(inline a: Long): git_index_add_option_t = a.toUInt
    val GIT_INDEX_ADD_DEFAULT = define(0)
    val GIT_INDEX_ADD_FORCE = define(1)
    val GIT_INDEX_ADD_DISABLE_PATHSPEC_MATCH = define(2)
    val GIT_INDEX_ADD_CHECK_PATHSPEC = define(4)

  opaque type git_index_capability_t = CInt
  object git_index_capability_t extends CEnum[git_index_capability_t]:
    given _tag: Tag[git_index_capability_t] = Tag.Int
    inline def define(inline a: CInt): git_index_capability_t = a
    val GIT_INDEX_CAPABILITY_IGNORE_CASE = define(1)
    val GIT_INDEX_CAPABILITY_NO_FILEMODE = define(2)
    val GIT_INDEX_CAPABILITY_NO_SYMLINKS = define(4)
    val GIT_INDEX_CAPABILITY_FROM_OWNER = define(-1)

  opaque type git_index_entry_extended_flag_t = CUnsignedInt
  object git_index_entry_extended_flag_t
      extends CEnumU[git_index_entry_extended_flag_t]:
    given _tag: Tag[git_index_entry_extended_flag_t] = Tag.UInt
    inline def define(inline a: Long): git_index_entry_extended_flag_t =
      a.toUInt
    val GIT_INDEX_ENTRY_INTENT_TO_ADD = define(8192)
    val GIT_INDEX_ENTRY_SKIP_WORKTREE = define(16384)
    val GIT_INDEX_ENTRY_EXTENDED_FLAGS = define(24576)
    val GIT_INDEX_ENTRY_UPTODATE = define(4)

  opaque type git_index_entry_flag_t = CUnsignedInt
  object git_index_entry_flag_t extends CEnumU[git_index_entry_flag_t]:
    given _tag: Tag[git_index_entry_flag_t] = Tag.UInt
    inline def define(inline a: Long): git_index_entry_flag_t = a.toUInt
    val GIT_INDEX_ENTRY_EXTENDED = define(16384)
    val GIT_INDEX_ENTRY_VALID = define(32768)

  opaque type git_index_stage_t = CInt
  object git_index_stage_t extends CEnum[git_index_stage_t]:
    given _tag: Tag[git_index_stage_t] = Tag.Int
    inline def define(inline a: CInt): git_index_stage_t = a
    val GIT_INDEX_STAGE_ANY = define(-1)
    val GIT_INDEX_STAGE_NORMAL = define(0)
    val GIT_INDEX_STAGE_ANCESTOR = define(1)
    val GIT_INDEX_STAGE_OURS = define(2)
    val GIT_INDEX_STAGE_THEIRS = define(3)

  opaque type git_libgit2_opt_t = CUnsignedInt
  object git_libgit2_opt_t extends CEnumU[git_libgit2_opt_t]:
    given _tag: Tag[git_libgit2_opt_t] = Tag.UInt
    inline def define(inline a: Long): git_libgit2_opt_t = a.toUInt
    val GIT_OPT_GET_MWINDOW_SIZE = define(0)
    val GIT_OPT_SET_MWINDOW_SIZE = define(1)
    val GIT_OPT_GET_MWINDOW_MAPPED_LIMIT = define(2)
    val GIT_OPT_SET_MWINDOW_MAPPED_LIMIT = define(3)
    val GIT_OPT_GET_SEARCH_PATH = define(4)
    val GIT_OPT_SET_SEARCH_PATH = define(5)
    val GIT_OPT_SET_CACHE_OBJECT_LIMIT = define(6)
    val GIT_OPT_SET_CACHE_MAX_SIZE = define(7)
    val GIT_OPT_ENABLE_CACHING = define(8)
    val GIT_OPT_GET_CACHED_MEMORY = define(9)
    val GIT_OPT_GET_TEMPLATE_PATH = define(10)
    val GIT_OPT_SET_TEMPLATE_PATH = define(11)
    val GIT_OPT_SET_SSL_CERT_LOCATIONS = define(12)
    val GIT_OPT_SET_USER_AGENT = define(13)
    val GIT_OPT_ENABLE_STRICT_OBJECT_CREATION = define(14)
    val GIT_OPT_ENABLE_STRICT_SYMBOLIC_REF_CREATION = define(15)
    val GIT_OPT_SET_SSL_CIPHERS = define(16)
    val GIT_OPT_GET_USER_AGENT = define(17)
    val GIT_OPT_ENABLE_OFS_DELTA = define(18)
    val GIT_OPT_ENABLE_FSYNC_GITDIR = define(19)
    val GIT_OPT_GET_WINDOWS_SHAREMODE = define(20)
    val GIT_OPT_SET_WINDOWS_SHAREMODE = define(21)
    val GIT_OPT_ENABLE_STRICT_HASH_VERIFICATION = define(22)
    val GIT_OPT_SET_ALLOCATOR = define(23)
    val GIT_OPT_ENABLE_UNSAVED_INDEX_SAFETY = define(24)
    val GIT_OPT_GET_PACK_MAX_OBJECTS = define(25)
    val GIT_OPT_SET_PACK_MAX_OBJECTS = define(26)
    val GIT_OPT_DISABLE_PACK_KEEP_FILE_CHECKS = define(27)
    val GIT_OPT_ENABLE_HTTP_EXPECT_CONTINUE = define(28)
    val GIT_OPT_GET_MWINDOW_FILE_LIMIT = define(29)
    val GIT_OPT_SET_MWINDOW_FILE_LIMIT = define(30)
    val GIT_OPT_SET_ODB_PACKED_PRIORITY = define(31)
    val GIT_OPT_SET_ODB_LOOSE_PRIORITY = define(32)
    val GIT_OPT_GET_EXTENSIONS = define(33)
    val GIT_OPT_SET_EXTENSIONS = define(34)

  opaque type git_merge_analysis_t = CUnsignedInt
  object git_merge_analysis_t extends CEnumU[git_merge_analysis_t]:
    given _tag: Tag[git_merge_analysis_t] = Tag.UInt
    inline def define(inline a: Long): git_merge_analysis_t = a.toUInt
    val GIT_MERGE_ANALYSIS_NONE = define(0)
    val GIT_MERGE_ANALYSIS_NORMAL = define(1)
    val GIT_MERGE_ANALYSIS_UP_TO_DATE = define(2)
    val GIT_MERGE_ANALYSIS_FASTFORWARD = define(4)
    val GIT_MERGE_ANALYSIS_UNBORN = define(8)

  opaque type git_merge_file_favor_t = CUnsignedInt
  object git_merge_file_favor_t extends CEnumU[git_merge_file_favor_t]:
    given _tag: Tag[git_merge_file_favor_t] = Tag.UInt
    inline def define(inline a: Long): git_merge_file_favor_t = a.toUInt
    val GIT_MERGE_FILE_FAVOR_NORMAL = define(0)
    val GIT_MERGE_FILE_FAVOR_OURS = define(1)
    val GIT_MERGE_FILE_FAVOR_THEIRS = define(2)
    val GIT_MERGE_FILE_FAVOR_UNION = define(3)

  opaque type git_merge_file_flag_t = CUnsignedInt
  object git_merge_file_flag_t extends CEnumU[git_merge_file_flag_t]:
    given _tag: Tag[git_merge_file_flag_t] = Tag.UInt
    inline def define(inline a: Long): git_merge_file_flag_t = a.toUInt
    val GIT_MERGE_FILE_DEFAULT = define(0)
    val GIT_MERGE_FILE_STYLE_MERGE = define(1)
    val GIT_MERGE_FILE_STYLE_DIFF3 = define(2)
    val GIT_MERGE_FILE_SIMPLIFY_ALNUM = define(4)
    val GIT_MERGE_FILE_IGNORE_WHITESPACE = define(8)
    val GIT_MERGE_FILE_IGNORE_WHITESPACE_CHANGE = define(16)
    val GIT_MERGE_FILE_IGNORE_WHITESPACE_EOL = define(32)
    val GIT_MERGE_FILE_DIFF_PATIENCE = define(64)
    val GIT_MERGE_FILE_DIFF_MINIMAL = define(128)
    val GIT_MERGE_FILE_STYLE_ZDIFF3 = define(256)
    val GIT_MERGE_FILE_ACCEPT_CONFLICTS = define(512)

  opaque type git_merge_flag_t = CUnsignedInt
  object git_merge_flag_t extends CEnumU[git_merge_flag_t]:
    given _tag: Tag[git_merge_flag_t] = Tag.UInt
    inline def define(inline a: Long): git_merge_flag_t = a.toUInt
    val GIT_MERGE_FIND_RENAMES = define(1)
    val GIT_MERGE_FAIL_ON_CONFLICT = define(2)
    val GIT_MERGE_SKIP_REUC = define(4)
    val GIT_MERGE_NO_RECURSIVE = define(8)
    val GIT_MERGE_VIRTUAL_BASE = define(16)

  opaque type git_merge_preference_t = CUnsignedInt
  object git_merge_preference_t extends CEnumU[git_merge_preference_t]:
    given _tag: Tag[git_merge_preference_t] = Tag.UInt
    inline def define(inline a: Long): git_merge_preference_t = a.toUInt
    val GIT_MERGE_PREFERENCE_NONE = define(0)
    val GIT_MERGE_PREFERENCE_NO_FASTFORWARD = define(1)
    val GIT_MERGE_PREFERENCE_FASTFORWARD_ONLY = define(2)

  opaque type git_object_t = CInt
  object git_object_t extends CEnum[git_object_t]:
    given _tag: Tag[git_object_t] = Tag.Int
    inline def define(inline a: CInt): git_object_t = a
    val GIT_OBJECT_ANY = define(-2)
    val GIT_OBJECT_INVALID = define(-1)
    val GIT_OBJECT_COMMIT = define(1)
    val GIT_OBJECT_TREE = define(2)
    val GIT_OBJECT_BLOB = define(3)
    val GIT_OBJECT_TAG = define(4)
    val GIT_OBJECT_OFS_DELTA = define(6)
    val GIT_OBJECT_REF_DELTA = define(7)

  opaque type git_odb_lookup_flags_t = CUnsignedInt
  object git_odb_lookup_flags_t extends CEnumU[git_odb_lookup_flags_t]:
    given _tag: Tag[git_odb_lookup_flags_t] = Tag.UInt
    inline def define(inline a: Long): git_odb_lookup_flags_t = a.toUInt
    val GIT_ODB_LOOKUP_NO_REFRESH = define(1)

  opaque type git_odb_stream_t = CUnsignedInt
  object git_odb_stream_t extends CEnumU[git_odb_stream_t]:
    given _tag: Tag[git_odb_stream_t] = Tag.UInt
    inline def define(inline a: Long): git_odb_stream_t = a.toUInt
    val GIT_STREAM_RDONLY = define(2)
    val GIT_STREAM_WRONLY = define(4)
    val GIT_STREAM_RW = define(6)

  opaque type git_packbuilder_stage_t = CUnsignedInt
  object git_packbuilder_stage_t extends CEnumU[git_packbuilder_stage_t]:
    given _tag: Tag[git_packbuilder_stage_t] = Tag.UInt
    inline def define(inline a: Long): git_packbuilder_stage_t = a.toUInt
    val GIT_PACKBUILDER_ADDING_OBJECTS = define(0)
    val GIT_PACKBUILDER_DELTAFICATION = define(1)

  opaque type git_pathspec_flag_t = CUnsignedInt
  object git_pathspec_flag_t extends CEnumU[git_pathspec_flag_t]:
    given _tag: Tag[git_pathspec_flag_t] = Tag.UInt
    inline def define(inline a: Long): git_pathspec_flag_t = a.toUInt
    val GIT_PATHSPEC_DEFAULT = define(0)
    val GIT_PATHSPEC_IGNORE_CASE = define(1)
    val GIT_PATHSPEC_USE_CASE = define(2)
    val GIT_PATHSPEC_NO_GLOB = define(4)
    val GIT_PATHSPEC_NO_MATCH_ERROR = define(8)
    val GIT_PATHSPEC_FIND_FAILURES = define(16)
    val GIT_PATHSPEC_FAILURES_ONLY = define(32)

  opaque type git_proxy_t = CUnsignedInt
  object git_proxy_t extends CEnumU[git_proxy_t]:
    given _tag: Tag[git_proxy_t] = Tag.UInt
    inline def define(inline a: Long): git_proxy_t = a.toUInt
    val GIT_PROXY_NONE = define(0)
    val GIT_PROXY_AUTO = define(1)
    val GIT_PROXY_SPECIFIED = define(2)

  opaque type git_rebase_operation_t = CUnsignedInt
  object git_rebase_operation_t extends CEnumU[git_rebase_operation_t]:
    given _tag: Tag[git_rebase_operation_t] = Tag.UInt
    inline def define(inline a: Long): git_rebase_operation_t = a.toUInt
    val GIT_REBASE_OPERATION_PICK = define(0)
    val GIT_REBASE_OPERATION_REWORD = define(1)
    val GIT_REBASE_OPERATION_EDIT = define(2)
    val GIT_REBASE_OPERATION_SQUASH = define(3)
    val GIT_REBASE_OPERATION_FIXUP = define(4)
    val GIT_REBASE_OPERATION_EXEC = define(5)

  opaque type git_reference_format_t = CUnsignedInt
  object git_reference_format_t extends CEnumU[git_reference_format_t]:
    given _tag: Tag[git_reference_format_t] = Tag.UInt
    inline def define(inline a: Long): git_reference_format_t = a.toUInt
    val GIT_REFERENCE_FORMAT_NORMAL = define(0)
    val GIT_REFERENCE_FORMAT_ALLOW_ONELEVEL = define(1)
    val GIT_REFERENCE_FORMAT_REFSPEC_PATTERN = define(2)
    val GIT_REFERENCE_FORMAT_REFSPEC_SHORTHAND = define(4)

  opaque type git_reference_t = CUnsignedInt
  object git_reference_t extends CEnumU[git_reference_t]:
    given _tag: Tag[git_reference_t] = Tag.UInt
    inline def define(inline a: Long): git_reference_t = a.toUInt
    val GIT_REFERENCE_INVALID = define(0)
    val GIT_REFERENCE_DIRECT = define(1)
    val GIT_REFERENCE_SYMBOLIC = define(2)
    val GIT_REFERENCE_ALL = define(3)

  opaque type git_remote_autotag_option_t = CUnsignedInt
  object git_remote_autotag_option_t
      extends CEnumU[git_remote_autotag_option_t]:
    given _tag: Tag[git_remote_autotag_option_t] = Tag.UInt
    inline def define(inline a: Long): git_remote_autotag_option_t = a.toUInt
    val GIT_REMOTE_DOWNLOAD_TAGS_UNSPECIFIED = define(0)
    val GIT_REMOTE_DOWNLOAD_TAGS_AUTO = define(1)
    val GIT_REMOTE_DOWNLOAD_TAGS_NONE = define(2)
    val GIT_REMOTE_DOWNLOAD_TAGS_ALL = define(3)

  opaque type git_remote_completion_t = CUnsignedInt
  object git_remote_completion_t extends CEnumU[git_remote_completion_t]:
    given _tag: Tag[git_remote_completion_t] = Tag.UInt
    inline def define(inline a: Long): git_remote_completion_t = a.toUInt
    val GIT_REMOTE_COMPLETION_DOWNLOAD = define(0)
    val GIT_REMOTE_COMPLETION_INDEXING = define(1)
    val GIT_REMOTE_COMPLETION_ERROR = define(2)

  opaque type git_remote_create_flags = CUnsignedInt
  object git_remote_create_flags extends CEnumU[git_remote_create_flags]:
    given _tag: Tag[git_remote_create_flags] = Tag.UInt
    inline def define(inline a: Long): git_remote_create_flags = a.toUInt
    val GIT_REMOTE_CREATE_SKIP_INSTEADOF = define(1)
    val GIT_REMOTE_CREATE_SKIP_DEFAULT_FETCHSPEC = define(2)

  opaque type git_remote_redirect_t = CUnsignedInt
  object git_remote_redirect_t extends CEnumU[git_remote_redirect_t]:
    given _tag: Tag[git_remote_redirect_t] = Tag.UInt
    inline def define(inline a: Long): git_remote_redirect_t = a.toUInt
    val GIT_REMOTE_REDIRECT_NONE = define(1)
    val GIT_REMOTE_REDIRECT_INITIAL = define(2)
    val GIT_REMOTE_REDIRECT_ALL = define(4)

  opaque type git_repository_init_flag_t = CUnsignedInt
  object git_repository_init_flag_t extends CEnumU[git_repository_init_flag_t]:
    given _tag: Tag[git_repository_init_flag_t] = Tag.UInt
    inline def define(inline a: Long): git_repository_init_flag_t = a.toUInt
    val GIT_REPOSITORY_INIT_BARE = define(1)
    val GIT_REPOSITORY_INIT_NO_REINIT = define(2)
    val GIT_REPOSITORY_INIT_NO_DOTGIT_DIR = define(4)
    val GIT_REPOSITORY_INIT_MKDIR = define(8)
    val GIT_REPOSITORY_INIT_MKPATH = define(16)
    val GIT_REPOSITORY_INIT_EXTERNAL_TEMPLATE = define(32)
    val GIT_REPOSITORY_INIT_RELATIVE_GITLINK = define(64)

  opaque type git_repository_init_mode_t = CUnsignedInt
  object git_repository_init_mode_t extends CEnumU[git_repository_init_mode_t]:
    given _tag: Tag[git_repository_init_mode_t] = Tag.UInt
    inline def define(inline a: Long): git_repository_init_mode_t = a.toUInt
    val GIT_REPOSITORY_INIT_SHARED_UMASK = define(0)
    val GIT_REPOSITORY_INIT_SHARED_GROUP = define(1533)
    val GIT_REPOSITORY_INIT_SHARED_ALL = define(1535)

  opaque type git_repository_item_t = CUnsignedInt
  object git_repository_item_t extends CEnumU[git_repository_item_t]:
    given _tag: Tag[git_repository_item_t] = Tag.UInt
    inline def define(inline a: Long): git_repository_item_t = a.toUInt
    val GIT_REPOSITORY_ITEM_GITDIR = define(0)
    val GIT_REPOSITORY_ITEM_WORKDIR = define(1)
    val GIT_REPOSITORY_ITEM_COMMONDIR = define(2)
    val GIT_REPOSITORY_ITEM_INDEX = define(3)
    val GIT_REPOSITORY_ITEM_OBJECTS = define(4)
    val GIT_REPOSITORY_ITEM_REFS = define(5)
    val GIT_REPOSITORY_ITEM_PACKED_REFS = define(6)
    val GIT_REPOSITORY_ITEM_REMOTES = define(7)
    val GIT_REPOSITORY_ITEM_CONFIG = define(8)
    val GIT_REPOSITORY_ITEM_INFO = define(9)
    val GIT_REPOSITORY_ITEM_HOOKS = define(10)
    val GIT_REPOSITORY_ITEM_LOGS = define(11)
    val GIT_REPOSITORY_ITEM_MODULES = define(12)
    val GIT_REPOSITORY_ITEM_WORKTREES = define(13)
    val GIT_REPOSITORY_ITEM__LAST = define(14)

  opaque type git_repository_open_flag_t = CUnsignedInt
  object git_repository_open_flag_t extends CEnumU[git_repository_open_flag_t]:
    given _tag: Tag[git_repository_open_flag_t] = Tag.UInt
    inline def define(inline a: Long): git_repository_open_flag_t = a.toUInt
    val GIT_REPOSITORY_OPEN_NO_SEARCH = define(1)
    val GIT_REPOSITORY_OPEN_CROSS_FS = define(2)
    val GIT_REPOSITORY_OPEN_BARE = define(4)
    val GIT_REPOSITORY_OPEN_NO_DOTGIT = define(8)
    val GIT_REPOSITORY_OPEN_FROM_ENV = define(16)

  opaque type git_repository_state_t = CUnsignedInt
  object git_repository_state_t extends CEnumU[git_repository_state_t]:
    given _tag: Tag[git_repository_state_t] = Tag.UInt
    inline def define(inline a: Long): git_repository_state_t = a.toUInt
    val GIT_REPOSITORY_STATE_NONE = define(0)
    val GIT_REPOSITORY_STATE_MERGE = define(1)
    val GIT_REPOSITORY_STATE_REVERT = define(2)
    val GIT_REPOSITORY_STATE_REVERT_SEQUENCE = define(3)
    val GIT_REPOSITORY_STATE_CHERRYPICK = define(4)
    val GIT_REPOSITORY_STATE_CHERRYPICK_SEQUENCE = define(5)
    val GIT_REPOSITORY_STATE_BISECT = define(6)
    val GIT_REPOSITORY_STATE_REBASE = define(7)
    val GIT_REPOSITORY_STATE_REBASE_INTERACTIVE = define(8)
    val GIT_REPOSITORY_STATE_REBASE_MERGE = define(9)
    val GIT_REPOSITORY_STATE_APPLY_MAILBOX = define(10)
    val GIT_REPOSITORY_STATE_APPLY_MAILBOX_OR_REBASE = define(11)

  opaque type git_reset_t = CUnsignedInt
  object git_reset_t extends CEnumU[git_reset_t]:
    given _tag: Tag[git_reset_t] = Tag.UInt
    inline def define(inline a: Long): git_reset_t = a.toUInt
    val GIT_RESET_SOFT = define(1)
    val GIT_RESET_MIXED = define(2)
    val GIT_RESET_HARD = define(3)

  opaque type git_revspec_t = CUnsignedInt
  object git_revspec_t extends CEnumU[git_revspec_t]:
    given _tag: Tag[git_revspec_t] = Tag.UInt
    inline def define(inline a: Long): git_revspec_t = a.toUInt
    val GIT_REVSPEC_SINGLE = define(1)
    val GIT_REVSPEC_RANGE = define(2)
    val GIT_REVSPEC_MERGE_BASE = define(4)

  opaque type git_sort_t = CUnsignedInt
  object git_sort_t extends CEnumU[git_sort_t]:
    given _tag: Tag[git_sort_t] = Tag.UInt
    inline def define(inline a: Long): git_sort_t = a.toUInt
    val GIT_SORT_NONE = define(0)
    val GIT_SORT_TOPOLOGICAL = define(1)
    val GIT_SORT_TIME = define(2)
    val GIT_SORT_REVERSE = define(4)

  opaque type git_stash_apply_flags = CUnsignedInt
  object git_stash_apply_flags extends CEnumU[git_stash_apply_flags]:
    given _tag: Tag[git_stash_apply_flags] = Tag.UInt
    inline def define(inline a: Long): git_stash_apply_flags = a.toUInt
    val GIT_STASH_APPLY_DEFAULT = define(0)
    val GIT_STASH_APPLY_REINSTATE_INDEX = define(1)

  opaque type git_stash_apply_progress_t = CUnsignedInt
  object git_stash_apply_progress_t extends CEnumU[git_stash_apply_progress_t]:
    given _tag: Tag[git_stash_apply_progress_t] = Tag.UInt
    inline def define(inline a: Long): git_stash_apply_progress_t = a.toUInt
    val GIT_STASH_APPLY_PROGRESS_NONE = define(0)
    val GIT_STASH_APPLY_PROGRESS_LOADING_STASH = define(1)
    val GIT_STASH_APPLY_PROGRESS_ANALYZE_INDEX = define(2)
    val GIT_STASH_APPLY_PROGRESS_ANALYZE_MODIFIED = define(3)
    val GIT_STASH_APPLY_PROGRESS_ANALYZE_UNTRACKED = define(4)
    val GIT_STASH_APPLY_PROGRESS_CHECKOUT_UNTRACKED = define(5)
    val GIT_STASH_APPLY_PROGRESS_CHECKOUT_MODIFIED = define(6)
    val GIT_STASH_APPLY_PROGRESS_DONE = define(7)

  opaque type git_stash_flags = CUnsignedInt
  object git_stash_flags extends CEnumU[git_stash_flags]:
    given _tag: Tag[git_stash_flags] = Tag.UInt
    inline def define(inline a: Long): git_stash_flags = a.toUInt
    val GIT_STASH_DEFAULT = define(0)
    val GIT_STASH_KEEP_INDEX = define(1)
    val GIT_STASH_INCLUDE_UNTRACKED = define(2)
    val GIT_STASH_INCLUDE_IGNORED = define(4)

  opaque type git_status_opt_t = CUnsignedInt
  object git_status_opt_t extends CEnumU[git_status_opt_t]:
    given _tag: Tag[git_status_opt_t] = Tag.UInt
    inline def define(inline a: Long): git_status_opt_t = a.toUInt
    val GIT_STATUS_OPT_INCLUDE_UNTRACKED = define(1)
    val GIT_STATUS_OPT_INCLUDE_IGNORED = define(2)
    val GIT_STATUS_OPT_INCLUDE_UNMODIFIED = define(4)
    val GIT_STATUS_OPT_EXCLUDE_SUBMODULES = define(8)
    val GIT_STATUS_OPT_RECURSE_UNTRACKED_DIRS = define(16)
    val GIT_STATUS_OPT_DISABLE_PATHSPEC_MATCH = define(32)
    val GIT_STATUS_OPT_RECURSE_IGNORED_DIRS = define(64)
    val GIT_STATUS_OPT_RENAMES_HEAD_TO_INDEX = define(128)
    val GIT_STATUS_OPT_RENAMES_INDEX_TO_WORKDIR = define(256)
    val GIT_STATUS_OPT_SORT_CASE_SENSITIVELY = define(512)
    val GIT_STATUS_OPT_SORT_CASE_INSENSITIVELY = define(1024)
    val GIT_STATUS_OPT_RENAMES_FROM_REWRITES = define(2048)
    val GIT_STATUS_OPT_NO_REFRESH = define(4096)
    val GIT_STATUS_OPT_UPDATE_INDEX = define(8192)
    val GIT_STATUS_OPT_INCLUDE_UNREADABLE = define(16384)
    val GIT_STATUS_OPT_INCLUDE_UNREADABLE_AS_UNTRACKED = define(32768)

  opaque type git_status_show_t = CUnsignedInt
  object git_status_show_t extends CEnumU[git_status_show_t]:
    given _tag: Tag[git_status_show_t] = Tag.UInt
    inline def define(inline a: Long): git_status_show_t = a.toUInt
    val GIT_STATUS_SHOW_INDEX_AND_WORKDIR = define(0)
    val GIT_STATUS_SHOW_INDEX_ONLY = define(1)
    val GIT_STATUS_SHOW_WORKDIR_ONLY = define(2)

  opaque type git_status_t = CUnsignedInt
  object git_status_t extends CEnumU[git_status_t]:
    given _tag: Tag[git_status_t] = Tag.UInt
    inline def define(inline a: Long): git_status_t = a.toUInt
    val GIT_STATUS_CURRENT = define(0)
    val GIT_STATUS_INDEX_NEW = define(1)
    val GIT_STATUS_INDEX_MODIFIED = define(2)
    val GIT_STATUS_INDEX_DELETED = define(4)
    val GIT_STATUS_INDEX_RENAMED = define(8)
    val GIT_STATUS_INDEX_TYPECHANGE = define(16)
    val GIT_STATUS_WT_NEW = define(128)
    val GIT_STATUS_WT_MODIFIED = define(256)
    val GIT_STATUS_WT_DELETED = define(512)
    val GIT_STATUS_WT_TYPECHANGE = define(1024)
    val GIT_STATUS_WT_RENAMED = define(2048)
    val GIT_STATUS_WT_UNREADABLE = define(4096)
    val GIT_STATUS_IGNORED = define(16384)
    val GIT_STATUS_CONFLICTED = define(32768)

  extension (a: git_status_t)
    def &(b: git_status_t): git_status_t = a & b
    def is(b: git_status_t): Boolean = (a & b) == b

  opaque type git_submodule_ignore_t = CInt
  object git_submodule_ignore_t extends CEnum[git_submodule_ignore_t]:
    given _tag: Tag[git_submodule_ignore_t] = Tag.Int
    inline def define(inline a: CInt): git_submodule_ignore_t = a
    val GIT_SUBMODULE_IGNORE_UNSPECIFIED = define(-1)
    val GIT_SUBMODULE_IGNORE_NONE = define(1)
    val GIT_SUBMODULE_IGNORE_UNTRACKED = define(2)
    val GIT_SUBMODULE_IGNORE_DIRTY = define(3)
    val GIT_SUBMODULE_IGNORE_ALL = define(4)

  opaque type git_submodule_recurse_t = CUnsignedInt
  object git_submodule_recurse_t extends CEnumU[git_submodule_recurse_t]:
    given _tag: Tag[git_submodule_recurse_t] = Tag.UInt
    inline def define(inline a: Long): git_submodule_recurse_t = a.toUInt
    val GIT_SUBMODULE_RECURSE_NO = define(0)
    val GIT_SUBMODULE_RECURSE_YES = define(1)
    val GIT_SUBMODULE_RECURSE_ONDEMAND = define(2)

  opaque type git_submodule_status_t = CUnsignedInt
  object git_submodule_status_t extends CEnumU[git_submodule_status_t]:
    given _tag: Tag[git_submodule_status_t] = Tag.UInt
    inline def define(inline a: Long): git_submodule_status_t = a.toUInt
    val GIT_SUBMODULE_STATUS_IN_HEAD = define(1)
    val GIT_SUBMODULE_STATUS_IN_INDEX = define(2)
    val GIT_SUBMODULE_STATUS_IN_CONFIG = define(4)
    val GIT_SUBMODULE_STATUS_IN_WD = define(8)
    val GIT_SUBMODULE_STATUS_INDEX_ADDED = define(16)
    val GIT_SUBMODULE_STATUS_INDEX_DELETED = define(32)
    val GIT_SUBMODULE_STATUS_INDEX_MODIFIED = define(64)
    val GIT_SUBMODULE_STATUS_WD_UNINITIALIZED = define(128)
    val GIT_SUBMODULE_STATUS_WD_ADDED = define(256)
    val GIT_SUBMODULE_STATUS_WD_DELETED = define(512)
    val GIT_SUBMODULE_STATUS_WD_MODIFIED = define(1024)
    val GIT_SUBMODULE_STATUS_WD_INDEX_MODIFIED = define(2048)
    val GIT_SUBMODULE_STATUS_WD_WD_MODIFIED = define(4096)
    val GIT_SUBMODULE_STATUS_WD_UNTRACKED = define(8192)

  opaque type git_submodule_update_t = CUnsignedInt
  object git_submodule_update_t extends CEnumU[git_submodule_update_t]:
    given _tag: Tag[git_submodule_update_t] = Tag.UInt
    inline def define(inline a: Long): git_submodule_update_t = a.toUInt
    val GIT_SUBMODULE_UPDATE_CHECKOUT = define(1)
    val GIT_SUBMODULE_UPDATE_REBASE = define(2)
    val GIT_SUBMODULE_UPDATE_MERGE = define(3)
    val GIT_SUBMODULE_UPDATE_NONE = define(4)
    val GIT_SUBMODULE_UPDATE_DEFAULT = define(0)

  opaque type git_trace_level_t = CUnsignedInt
  object git_trace_level_t extends CEnumU[git_trace_level_t]:
    given _tag: Tag[git_trace_level_t] = Tag.UInt
    inline def define(inline a: Long): git_trace_level_t = a.toUInt
    val GIT_TRACE_NONE = define(0)
    val GIT_TRACE_FATAL = define(1)
    val GIT_TRACE_ERROR = define(2)
    val GIT_TRACE_WARN = define(3)
    val GIT_TRACE_INFO = define(4)
    val GIT_TRACE_DEBUG = define(5)
    val GIT_TRACE_TRACE = define(6)

  opaque type git_tree_update_t = CUnsignedInt
  object git_tree_update_t extends CEnumU[git_tree_update_t]:
    given _tag: Tag[git_tree_update_t] = Tag.UInt
    inline def define(inline a: Long): git_tree_update_t = a.toUInt
    val GIT_TREE_UPDATE_UPSERT = define(0)
    val GIT_TREE_UPDATE_REMOVE = define(1)

  opaque type git_treewalk_mode = CUnsignedInt
  object git_treewalk_mode extends CEnumU[git_treewalk_mode]:
    given _tag: Tag[git_treewalk_mode] = Tag.UInt
    inline def define(inline a: Long): git_treewalk_mode = a.toUInt
    val GIT_TREEWALK_PRE = define(0)
    val GIT_TREEWALK_POST = define(1)

  opaque type git_worktree_prune_t = CUnsignedInt
  object git_worktree_prune_t extends CEnumU[git_worktree_prune_t]:
    given _tag: Tag[git_worktree_prune_t] = Tag.UInt
    inline def define(inline a: Long): git_worktree_prune_t = a.toUInt
    val GIT_WORKTREE_PRUNE_VALID = define(1)
    val GIT_WORKTREE_PRUNE_LOCKED = define(2)
    val GIT_WORKTREE_PRUNE_WORKING_TREE = define(4)
  opaque type git_apply_delta_cb =
    CFuncPtr2[Ptr[git_diff_delta], Ptr[Byte], CInt]
  object git_apply_delta_cb:
    given _tag: Tag[git_apply_delta_cb] =
      Tag.materializeCFuncPtr2[Ptr[git_diff_delta], Ptr[Byte], CInt]
    inline def apply(
        inline o: CFuncPtr2[Ptr[git_diff_delta], Ptr[Byte], CInt]
    ): git_apply_delta_cb = o

  opaque type git_apply_hunk_cb = CFuncPtr2[Ptr[git_diff_hunk], Ptr[Byte], CInt]
  object git_apply_hunk_cb:
    given _tag: Tag[git_apply_hunk_cb] =
      Tag.materializeCFuncPtr2[Ptr[git_diff_hunk], Ptr[Byte], CInt]
    inline def apply(
        inline o: CFuncPtr2[Ptr[git_diff_hunk], Ptr[Byte], CInt]
    ): git_apply_hunk_cb = o

  opaque type git_attr_foreach_cb = CFuncPtr3[CString, CString, Ptr[Byte], CInt]
  object git_attr_foreach_cb:
    given _tag: Tag[git_attr_foreach_cb] =
      Tag.materializeCFuncPtr3[CString, CString, Ptr[Byte], CInt]
    inline def apply(
        inline o: CFuncPtr3[CString, CString, Ptr[Byte], CInt]
    ): git_attr_foreach_cb = o

  type git_attr_t = git_attr_value_t
  object git_attr_t:
    given _tag: Tag[git_attr_t] = git_attr_value_t._tag

  opaque type git_checkout_notify_cb =
    CFuncPtr6[git_checkout_notify_t, CString, Ptr[git_diff_file], Ptr[
      git_diff_file
    ], Ptr[git_diff_file], Ptr[Byte], CInt]
  object git_checkout_notify_cb:
    given _tag: Tag[git_checkout_notify_cb] =
      Tag.materializeCFuncPtr6[git_checkout_notify_t, CString, Ptr[
        git_diff_file
      ], Ptr[git_diff_file], Ptr[git_diff_file], Ptr[Byte], CInt]
    inline def apply(
        inline o: CFuncPtr6[git_checkout_notify_t, CString, Ptr[
          git_diff_file
        ], Ptr[git_diff_file], Ptr[git_diff_file], Ptr[Byte], CInt]
    ): git_checkout_notify_cb = o

  opaque type git_checkout_perfdata_cb =
    CFuncPtr2[Ptr[git_checkout_perfdata], Ptr[Byte], Unit]
  object git_checkout_perfdata_cb:
    given _tag: Tag[git_checkout_perfdata_cb] =
      Tag.materializeCFuncPtr2[Ptr[git_checkout_perfdata], Ptr[Byte], Unit]
    inline def apply(
        inline o: CFuncPtr2[Ptr[git_checkout_perfdata], Ptr[Byte], Unit]
    ): git_checkout_perfdata_cb = o

  opaque type git_checkout_progress_cb =
    CFuncPtr4[CString, size_t, size_t, Ptr[Byte], Unit]
  object git_checkout_progress_cb:
    given _tag: Tag[git_checkout_progress_cb] =
      Tag.materializeCFuncPtr4[CString, size_t, size_t, Ptr[Byte], Unit]
    inline def apply(
        inline o: CFuncPtr4[CString, size_t, size_t, Ptr[Byte], Unit]
    ): git_checkout_progress_cb = o

  opaque type git_commit_create_cb =
    CFuncPtr9[Ptr[git_oid], Ptr[git_signature], Ptr[
      git_signature
    ], CString, CString, Ptr[git_tree], size_t, Unit, Ptr[Byte], CInt]
  object git_commit_create_cb:
    given _tag: Tag[git_commit_create_cb] =
      Tag.materializeCFuncPtr9[Ptr[git_oid], Ptr[git_signature], Ptr[
        git_signature
      ], CString, CString, Ptr[git_tree], size_t, Unit, Ptr[Byte], CInt]
    inline def apply(
        inline o: CFuncPtr9[Ptr[git_oid], Ptr[git_signature], Ptr[
          git_signature
        ], CString, CString, Ptr[git_tree], size_t, Unit, Ptr[Byte], CInt]
    ): git_commit_create_cb = o

  opaque type git_commit_signing_cb =
    CFuncPtr4[Ptr[git_buf], Ptr[git_buf], CString, Ptr[Byte], CInt]
  object git_commit_signing_cb:
    given _tag: Tag[git_commit_signing_cb] = Tag.materializeCFuncPtr4[Ptr[
      git_buf
    ], Ptr[git_buf], CString, Ptr[Byte], CInt]
    inline def apply(
        inline o: CFuncPtr4[Ptr[git_buf], Ptr[git_buf], CString, Ptr[
          Byte
        ], CInt]
    ): git_commit_signing_cb = o

  opaque type git_config_foreach_cb =
    CFuncPtr2[Ptr[git_config_entry], Ptr[Byte], CInt]
  object git_config_foreach_cb:
    given _tag: Tag[git_config_foreach_cb] =
      Tag.materializeCFuncPtr2[Ptr[git_config_entry], Ptr[Byte], CInt]
    inline def apply(
        inline o: CFuncPtr2[Ptr[git_config_entry], Ptr[Byte], CInt]
    ): git_config_foreach_cb = o

  type git_cred = git_credential
  object git_cred:
    given _tag: Tag[git_cred] = git_credential._tag

  type git_cred_acquire_cb = git_credential_acquire_cb
  object git_cred_acquire_cb:
    given _tag: Tag[git_cred_acquire_cb] = git_credential_acquire_cb._tag

  type git_cred_default = git_credential_default
  object git_cred_default:
    given _tag: Tag[git_cred_default] = git_credential_default._tag

  type git_cred_sign_callback = git_credential_sign_cb
  object git_cred_sign_callback:
    given _tag: Tag[git_cred_sign_callback] = git_credential_sign_cb._tag

  type git_cred_sign_cb = git_credential_sign_cb
  object git_cred_sign_cb:
    given _tag: Tag[git_cred_sign_cb] = git_credential_sign_cb._tag

  type git_cred_ssh_custom = git_credential_ssh_custom
  object git_cred_ssh_custom:
    given _tag: Tag[git_cred_ssh_custom] = git_credential_ssh_custom._tag

  type git_cred_ssh_interactive = git_credential_ssh_interactive
  object git_cred_ssh_interactive:
    given _tag: Tag[git_cred_ssh_interactive] =
      git_credential_ssh_interactive._tag

  type git_cred_ssh_interactive_callback = git_credential_ssh_interactive_cb
  object git_cred_ssh_interactive_callback:
    given _tag: Tag[git_cred_ssh_interactive_callback] =
      git_credential_ssh_interactive_cb._tag

  type git_cred_ssh_interactive_cb = git_credential_ssh_interactive_cb
  object git_cred_ssh_interactive_cb:
    given _tag: Tag[git_cred_ssh_interactive_cb] =
      git_credential_ssh_interactive_cb._tag

  type git_cred_ssh_key = git_credential_ssh_key
  object git_cred_ssh_key:
    given _tag: Tag[git_cred_ssh_key] = git_credential_ssh_key._tag

  type git_cred_username = git_credential_username
  object git_cred_username:
    given _tag: Tag[git_cred_username] = git_credential_username._tag

  type git_cred_userpass_payload = git_credential_userpass_payload
  object git_cred_userpass_payload:
    given _tag: Tag[git_cred_userpass_payload] =
      git_credential_userpass_payload._tag

  type git_cred_userpass_plaintext = git_credential_userpass_plaintext
  object git_cred_userpass_plaintext:
    given _tag: Tag[git_cred_userpass_plaintext] =
      git_credential_userpass_plaintext._tag

  opaque type git_credential_acquire_cb = CFuncPtr5[Ptr[
    Ptr[git_credential]
  ], CString, CString, CUnsignedInt, Ptr[Byte], CInt]
  object git_credential_acquire_cb:
    given _tag: Tag[git_credential_acquire_cb] = Tag.materializeCFuncPtr5[Ptr[
      Ptr[git_credential]
    ], CString, CString, CUnsignedInt, Ptr[Byte], CInt]
    inline def apply(
        inline o: CFuncPtr5[Ptr[
          Ptr[git_credential]
        ], CString, CString, CUnsignedInt, Ptr[Byte], CInt]
    ): git_credential_acquire_cb = o

  opaque type git_credential_sign_cb = CFuncPtr6[Ptr[LIBSSH2_SESSION], Ptr[
    Ptr[CUnsignedChar]
  ], Ptr[size_t], Ptr[CUnsignedChar], size_t, Ptr[Ptr[Byte]], CInt]
  object git_credential_sign_cb:
    given _tag: Tag[git_credential_sign_cb] =
      Tag.materializeCFuncPtr6[Ptr[LIBSSH2_SESSION], Ptr[
        Ptr[CUnsignedChar]
      ], Ptr[size_t], Ptr[CUnsignedChar], size_t, Ptr[Ptr[Byte]], CInt]
    inline def apply(
        inline o: CFuncPtr6[Ptr[LIBSSH2_SESSION], Ptr[Ptr[CUnsignedChar]], Ptr[
          size_t
        ], Ptr[CUnsignedChar], size_t, Ptr[Ptr[Byte]], CInt]
    ): git_credential_sign_cb = o

  opaque type git_credential_ssh_interactive_cb =
    CFuncPtr8[CString, CInt, CString, CInt, CInt, Ptr[
      LIBSSH2_USERAUTH_KBDINT_PROMPT
    ], Ptr[LIBSSH2_USERAUTH_KBDINT_RESPONSE], Ptr[Ptr[Byte]], Unit]
  object git_credential_ssh_interactive_cb:
    given _tag: Tag[git_credential_ssh_interactive_cb] =
      Tag.materializeCFuncPtr8[CString, CInt, CString, CInt, CInt, Ptr[
        LIBSSH2_USERAUTH_KBDINT_PROMPT
      ], Ptr[LIBSSH2_USERAUTH_KBDINT_RESPONSE], Ptr[Ptr[Byte]], Unit]
    inline def apply(
        inline o: CFuncPtr8[CString, CInt, CString, CInt, CInt, Ptr[
          LIBSSH2_USERAUTH_KBDINT_PROMPT
        ], Ptr[LIBSSH2_USERAUTH_KBDINT_RESPONSE], Ptr[Ptr[Byte]], Unit]
    ): git_credential_ssh_interactive_cb = o

  type git_cvar_map = git_configmap
  object git_cvar_map:
    given _tag: Tag[git_cvar_map] = git_configmap._tag

  opaque type git_diff_binary_cb =
    CFuncPtr3[Ptr[git_diff_delta], Ptr[git_diff_binary], Ptr[Byte], CInt]
  object git_diff_binary_cb:
    given _tag: Tag[git_diff_binary_cb] = Tag.materializeCFuncPtr3[Ptr[
      git_diff_delta
    ], Ptr[git_diff_binary], Ptr[Byte], CInt]
    inline def apply(
        inline o: CFuncPtr3[Ptr[git_diff_delta], Ptr[git_diff_binary], Ptr[
          Byte
        ], CInt]
    ): git_diff_binary_cb = o

  opaque type git_diff_file_cb =
    CFuncPtr3[Ptr[git_diff_delta], Float, Ptr[Byte], CInt]
  object git_diff_file_cb:
    given _tag: Tag[git_diff_file_cb] =
      Tag.materializeCFuncPtr3[Ptr[git_diff_delta], Float, Ptr[Byte], CInt]
    inline def apply(
        inline o: CFuncPtr3[Ptr[git_diff_delta], Float, Ptr[Byte], CInt]
    ): git_diff_file_cb = o

  opaque type git_diff_hunk_cb =
    CFuncPtr3[Ptr[git_diff_delta], Ptr[git_diff_hunk], Ptr[Byte], CInt]
  object git_diff_hunk_cb:
    given _tag: Tag[git_diff_hunk_cb] = Tag.materializeCFuncPtr3[Ptr[
      git_diff_delta
    ], Ptr[git_diff_hunk], Ptr[Byte], CInt]
    inline def apply(
        inline o: CFuncPtr3[Ptr[git_diff_delta], Ptr[git_diff_hunk], Ptr[
          Byte
        ], CInt]
    ): git_diff_hunk_cb = o

  opaque type git_diff_line_cb = CFuncPtr4[Ptr[git_diff_delta], Ptr[
    git_diff_hunk
  ], Ptr[git_diff_line], Ptr[Byte], CInt]
  object git_diff_line_cb:
    given _tag: Tag[git_diff_line_cb] = Tag.materializeCFuncPtr4[Ptr[
      git_diff_delta
    ], Ptr[git_diff_hunk], Ptr[git_diff_line], Ptr[Byte], CInt]
    inline def apply(
        inline o: CFuncPtr4[Ptr[git_diff_delta], Ptr[git_diff_hunk], Ptr[
          git_diff_line
        ], Ptr[Byte], CInt]
    ): git_diff_line_cb = o

  opaque type git_diff_notify_cb =
    CFuncPtr4[Ptr[git_diff], Ptr[git_diff_delta], CString, Ptr[Byte], CInt]
  object git_diff_notify_cb:
    given _tag: Tag[git_diff_notify_cb] = Tag.materializeCFuncPtr4[Ptr[
      git_diff
    ], Ptr[git_diff_delta], CString, Ptr[Byte], CInt]
    inline def apply(
        inline o: CFuncPtr4[Ptr[git_diff], Ptr[git_diff_delta], CString, Ptr[
          Byte
        ], CInt]
    ): git_diff_notify_cb = o

  opaque type git_diff_progress_cb =
    CFuncPtr4[Ptr[git_diff], CString, CString, Ptr[Byte], CInt]
  object git_diff_progress_cb:
    given _tag: Tag[git_diff_progress_cb] =
      Tag.materializeCFuncPtr4[Ptr[git_diff], CString, CString, Ptr[Byte], CInt]
    inline def apply(
        inline o: CFuncPtr4[Ptr[git_diff], CString, CString, Ptr[Byte], CInt]
    ): git_diff_progress_cb = o

  opaque type git_headlist_cb = CFuncPtr2[Ptr[git_remote_head], Ptr[Byte], CInt]
  object git_headlist_cb:
    given _tag: Tag[git_headlist_cb] =
      Tag.materializeCFuncPtr2[Ptr[git_remote_head], Ptr[Byte], CInt]
    inline def apply(
        inline o: CFuncPtr2[Ptr[git_remote_head], Ptr[Byte], CInt]
    ): git_headlist_cb = o

  opaque type git_index_matched_path_cb =
    CFuncPtr3[CString, CString, Ptr[Byte], CInt]
  object git_index_matched_path_cb:
    given _tag: Tag[git_index_matched_path_cb] =
      Tag.materializeCFuncPtr3[CString, CString, Ptr[Byte], CInt]
    inline def apply(
        inline o: CFuncPtr3[CString, CString, Ptr[Byte], CInt]
    ): git_index_matched_path_cb = o

  opaque type git_indexer_progress_cb =
    CFuncPtr2[Ptr[git_indexer_progress], Ptr[Byte], CInt]
  object git_indexer_progress_cb:
    given _tag: Tag[git_indexer_progress_cb] =
      Tag.materializeCFuncPtr2[Ptr[git_indexer_progress], Ptr[Byte], CInt]
    inline def apply(
        inline o: CFuncPtr2[Ptr[git_indexer_progress], Ptr[Byte], CInt]
    ): git_indexer_progress_cb = o

  opaque type git_note_foreach_cb =
    CFuncPtr3[Ptr[git_oid], Ptr[git_oid], Ptr[Byte], CInt]
  object git_note_foreach_cb:
    given _tag: Tag[git_note_foreach_cb] =
      Tag.materializeCFuncPtr3[Ptr[git_oid], Ptr[git_oid], Ptr[Byte], CInt]
    inline def apply(
        inline o: CFuncPtr3[Ptr[git_oid], Ptr[git_oid], Ptr[Byte], CInt]
    ): git_note_foreach_cb = o

  type git_object_size_t = uint64_t
  object git_object_size_t:
    given _tag: Tag[git_object_size_t] = uint64_t._tag

  opaque type git_odb_foreach_cb = CFuncPtr2[Ptr[git_oid], Ptr[Byte], CInt]
  object git_odb_foreach_cb:
    given _tag: Tag[git_odb_foreach_cb] =
      Tag.materializeCFuncPtr2[Ptr[git_oid], Ptr[Byte], CInt]
    inline def apply(
        inline o: CFuncPtr2[Ptr[git_oid], Ptr[Byte], CInt]
    ): git_odb_foreach_cb = o

  type git_off_t = int64_t
  object git_off_t:
    given _tag: Tag[git_off_t] = int64_t._tag

  opaque type git_packbuilder_foreach_cb =
    CFuncPtr3[Ptr[Byte], size_t, Ptr[Byte], CInt]
  object git_packbuilder_foreach_cb:
    given _tag: Tag[git_packbuilder_foreach_cb] =
      Tag.materializeCFuncPtr3[Ptr[Byte], size_t, Ptr[Byte], CInt]
    inline def apply(
        inline o: CFuncPtr3[Ptr[Byte], size_t, Ptr[Byte], CInt]
    ): git_packbuilder_foreach_cb = o

  opaque type git_packbuilder_progress =
    CFuncPtr4[CInt, uint32_t, uint32_t, Ptr[Byte], CInt]
  object git_packbuilder_progress:
    given _tag: Tag[git_packbuilder_progress] =
      Tag.materializeCFuncPtr4[CInt, uint32_t, uint32_t, Ptr[Byte], CInt]
    inline def apply(
        inline o: CFuncPtr4[CInt, uint32_t, uint32_t, Ptr[Byte], CInt]
    ): git_packbuilder_progress = o

  opaque type git_push_negotiation =
    CFuncPtr3[Ptr[Ptr[git_push_update]], size_t, Ptr[Byte], CInt]
  object git_push_negotiation:
    given _tag: Tag[git_push_negotiation] = Tag
      .materializeCFuncPtr3[Ptr[Ptr[git_push_update]], size_t, Ptr[Byte], CInt]
    inline def apply(
        inline o: CFuncPtr3[Ptr[Ptr[git_push_update]], size_t, Ptr[Byte], CInt]
    ): git_push_negotiation = o

  type git_push_transfer_progress = git_push_transfer_progress_cb
  object git_push_transfer_progress:
    given _tag: Tag[git_push_transfer_progress] =
      git_push_transfer_progress_cb._tag

  opaque type git_push_transfer_progress_cb =
    CFuncPtr4[CUnsignedInt, CUnsignedInt, size_t, Ptr[Byte], CInt]
  object git_push_transfer_progress_cb:
    given _tag: Tag[git_push_transfer_progress_cb] = Tag
      .materializeCFuncPtr4[CUnsignedInt, CUnsignedInt, size_t, Ptr[Byte], CInt]
    inline def apply(
        inline o: CFuncPtr4[CUnsignedInt, CUnsignedInt, size_t, Ptr[Byte], CInt]
    ): git_push_transfer_progress_cb = o

  opaque type git_push_update_reference_cb =
    CFuncPtr3[CString, CString, Ptr[Byte], CInt]
  object git_push_update_reference_cb:
    given _tag: Tag[git_push_update_reference_cb] =
      Tag.materializeCFuncPtr3[CString, CString, Ptr[Byte], CInt]
    inline def apply(
        inline o: CFuncPtr3[CString, CString, Ptr[Byte], CInt]
    ): git_push_update_reference_cb = o

  opaque type git_reference_foreach_cb =
    CFuncPtr2[Ptr[git_reference], Ptr[Byte], CInt]
  object git_reference_foreach_cb:
    given _tag: Tag[git_reference_foreach_cb] =
      Tag.materializeCFuncPtr2[Ptr[git_reference], Ptr[Byte], CInt]
    inline def apply(
        inline o: CFuncPtr2[Ptr[git_reference], Ptr[Byte], CInt]
    ): git_reference_foreach_cb = o

  opaque type git_reference_foreach_name_cb =
    CFuncPtr2[CString, Ptr[Byte], CInt]
  object git_reference_foreach_name_cb:
    given _tag: Tag[git_reference_foreach_name_cb] =
      Tag.materializeCFuncPtr2[CString, Ptr[Byte], CInt]
    inline def apply(
        inline o: CFuncPtr2[CString, Ptr[Byte], CInt]
    ): git_reference_foreach_name_cb = o

  opaque type git_remote_create_cb = CFuncPtr5[Ptr[Ptr[git_remote]], Ptr[
    git_repository
  ], CString, CString, Ptr[Byte], CInt]
  object git_remote_create_cb:
    given _tag: Tag[git_remote_create_cb] = Tag.materializeCFuncPtr5[Ptr[
      Ptr[git_remote]
    ], Ptr[git_repository], CString, CString, Ptr[Byte], CInt]
    inline def apply(
        inline o: CFuncPtr5[Ptr[Ptr[git_remote]], Ptr[
          git_repository
        ], CString, CString, Ptr[Byte], CInt]
    ): git_remote_create_cb = o

  opaque type git_remote_ready_cb =
    CFuncPtr3[Ptr[git_remote], CInt, Ptr[Byte], CInt]
  object git_remote_ready_cb:
    given _tag: Tag[git_remote_ready_cb] =
      Tag.materializeCFuncPtr3[Ptr[git_remote], CInt, Ptr[Byte], CInt]
    inline def apply(
        inline o: CFuncPtr3[Ptr[git_remote], CInt, Ptr[Byte], CInt]
    ): git_remote_ready_cb = o

  opaque type git_repository_create_cb =
    CFuncPtr4[Ptr[Ptr[git_repository]], CString, CInt, Ptr[Byte], CInt]
  object git_repository_create_cb:
    given _tag: Tag[git_repository_create_cb] = Tag.materializeCFuncPtr4[Ptr[
      Ptr[git_repository]
    ], CString, CInt, Ptr[Byte], CInt]
    inline def apply(
        inline o: CFuncPtr4[Ptr[Ptr[git_repository]], CString, CInt, Ptr[
          Byte
        ], CInt]
    ): git_repository_create_cb = o

  opaque type git_repository_fetchhead_foreach_cb =
    CFuncPtr5[CString, CString, Ptr[git_oid], CUnsignedInt, Ptr[Byte], CInt]
  object git_repository_fetchhead_foreach_cb:
    given _tag: Tag[git_repository_fetchhead_foreach_cb] =
      Tag.materializeCFuncPtr5[CString, CString, Ptr[
        git_oid
      ], CUnsignedInt, Ptr[Byte], CInt]
    inline def apply(
        inline o: CFuncPtr5[CString, CString, Ptr[git_oid], CUnsignedInt, Ptr[
          Byte
        ], CInt]
    ): git_repository_fetchhead_foreach_cb = o

  opaque type git_repository_mergehead_foreach_cb =
    CFuncPtr2[Ptr[git_oid], Ptr[Byte], CInt]
  object git_repository_mergehead_foreach_cb:
    given _tag: Tag[git_repository_mergehead_foreach_cb] =
      Tag.materializeCFuncPtr2[Ptr[git_oid], Ptr[Byte], CInt]
    inline def apply(
        inline o: CFuncPtr2[Ptr[git_oid], Ptr[Byte], CInt]
    ): git_repository_mergehead_foreach_cb = o

  type git_revparse_mode_t = git_revspec_t
  object git_revparse_mode_t:
    given _tag: Tag[git_revparse_mode_t] = git_revspec_t._tag

  opaque type git_revwalk_hide_cb = CFuncPtr2[Ptr[git_oid], Ptr[Byte], CInt]
  object git_revwalk_hide_cb:
    given _tag: Tag[git_revwalk_hide_cb] =
      Tag.materializeCFuncPtr2[Ptr[git_oid], Ptr[Byte], CInt]
    inline def apply(
        inline o: CFuncPtr2[Ptr[git_oid], Ptr[Byte], CInt]
    ): git_revwalk_hide_cb = o

  opaque type git_stash_apply_progress_cb =
    CFuncPtr2[git_stash_apply_progress_t, Ptr[Byte], CInt]
  object git_stash_apply_progress_cb:
    given _tag: Tag[git_stash_apply_progress_cb] =
      Tag.materializeCFuncPtr2[git_stash_apply_progress_t, Ptr[Byte], CInt]
    inline def apply(
        inline o: CFuncPtr2[git_stash_apply_progress_t, Ptr[Byte], CInt]
    ): git_stash_apply_progress_cb = o

  opaque type git_stash_cb =
    CFuncPtr4[size_t, CString, Ptr[git_oid], Ptr[Byte], CInt]
  object git_stash_cb:
    given _tag: Tag[git_stash_cb] =
      Tag.materializeCFuncPtr4[size_t, CString, Ptr[git_oid], Ptr[Byte], CInt]
    inline def apply(
        inline o: CFuncPtr4[size_t, CString, Ptr[git_oid], Ptr[Byte], CInt]
    ): git_stash_cb = o

  opaque type git_status_cb = CFuncPtr3[CString, CUnsignedInt, Ptr[Byte], CInt]
  object git_status_cb:
    given _tag: Tag[git_status_cb] =
      Tag.materializeCFuncPtr3[CString, CUnsignedInt, Ptr[Byte], CInt]
    inline def apply(
        inline o: CFuncPtr3[CString, CUnsignedInt, Ptr[Byte], CInt]
    ): git_status_cb = o

  opaque type git_submodule_cb =
    CFuncPtr3[Ptr[git_submodule], CString, Ptr[Byte], CInt]
  object git_submodule_cb:
    given _tag: Tag[git_submodule_cb] =
      Tag.materializeCFuncPtr3[Ptr[git_submodule], CString, Ptr[Byte], CInt]
    inline def apply(
        inline o: CFuncPtr3[Ptr[git_submodule], CString, Ptr[Byte], CInt]
    ): git_submodule_cb = o

  opaque type git_tag_foreach_cb =
    CFuncPtr3[CString, Ptr[git_oid], Ptr[Byte], CInt]
  object git_tag_foreach_cb:
    given _tag: Tag[git_tag_foreach_cb] =
      Tag.materializeCFuncPtr3[CString, Ptr[git_oid], Ptr[Byte], CInt]
    inline def apply(
        inline o: CFuncPtr3[CString, Ptr[git_oid], Ptr[Byte], CInt]
    ): git_tag_foreach_cb = o

  type git_time_t = int64_t
  object git_time_t:
    given _tag: Tag[git_time_t] = int64_t._tag

  type git_trace_callback = git_trace_cb
  object git_trace_callback:
    given _tag: Tag[git_trace_callback] = git_trace_cb._tag

  opaque type git_trace_cb = CFuncPtr2[git_trace_level_t, CString, Unit]
  object git_trace_cb:
    given _tag: Tag[git_trace_cb] =
      Tag.materializeCFuncPtr2[git_trace_level_t, CString, Unit]
    inline def apply(
        inline o: CFuncPtr2[git_trace_level_t, CString, Unit]
    ): git_trace_cb = o

  type git_transfer_progress = git_indexer_progress
  object git_transfer_progress:
    given _tag: Tag[git_transfer_progress] = git_indexer_progress._tag

  type git_transfer_progress_cb = git_indexer_progress_cb
  object git_transfer_progress_cb:
    given _tag: Tag[git_transfer_progress_cb] = git_indexer_progress_cb._tag

  opaque type git_transport_cb =
    CFuncPtr3[Ptr[Ptr[git_transport]], Ptr[git_remote], Ptr[Byte], CInt]
  object git_transport_cb:
    given _tag: Tag[git_transport_cb] = Tag.materializeCFuncPtr3[Ptr[
      Ptr[git_transport]
    ], Ptr[git_remote], Ptr[Byte], CInt]
    inline def apply(
        inline o: CFuncPtr3[Ptr[Ptr[git_transport]], Ptr[git_remote], Ptr[
          Byte
        ], CInt]
    ): git_transport_cb = o

  opaque type git_transport_certificate_check_cb =
    CFuncPtr4[Ptr[git_cert], CInt, CString, Ptr[Byte], CInt]
  object git_transport_certificate_check_cb:
    given _tag: Tag[git_transport_certificate_check_cb] =
      Tag.materializeCFuncPtr4[Ptr[git_cert], CInt, CString, Ptr[Byte], CInt]
    inline def apply(
        inline o: CFuncPtr4[Ptr[git_cert], CInt, CString, Ptr[Byte], CInt]
    ): git_transport_certificate_check_cb = o

  opaque type git_transport_message_cb =
    CFuncPtr3[CString, CInt, Ptr[Byte], CInt]
  object git_transport_message_cb:
    given _tag: Tag[git_transport_message_cb] =
      Tag.materializeCFuncPtr3[CString, CInt, Ptr[Byte], CInt]
    inline def apply(
        inline o: CFuncPtr3[CString, CInt, Ptr[Byte], CInt]
    ): git_transport_message_cb = o

  opaque type git_treebuilder_filter_cb =
    CFuncPtr2[Ptr[git_tree_entry], Ptr[Byte], CInt]
  object git_treebuilder_filter_cb:
    given _tag: Tag[git_treebuilder_filter_cb] =
      Tag.materializeCFuncPtr2[Ptr[git_tree_entry], Ptr[Byte], CInt]
    inline def apply(
        inline o: CFuncPtr2[Ptr[git_tree_entry], Ptr[Byte], CInt]
    ): git_treebuilder_filter_cb = o

  opaque type git_treewalk_cb =
    CFuncPtr3[CString, Ptr[git_tree_entry], Ptr[Byte], CInt]
  object git_treewalk_cb:
    given _tag: Tag[git_treewalk_cb] =
      Tag.materializeCFuncPtr3[CString, Ptr[git_tree_entry], Ptr[Byte], CInt]
    inline def apply(
        inline o: CFuncPtr3[CString, Ptr[git_tree_entry], Ptr[Byte], CInt]
    ): git_treewalk_cb = o

  opaque type git_url_resolve_cb =
    CFuncPtr4[Ptr[git_buf], CString, CInt, Ptr[Byte], CInt]
  object git_url_resolve_cb:
    given _tag: Tag[git_url_resolve_cb] =
      Tag.materializeCFuncPtr4[Ptr[git_buf], CString, CInt, Ptr[Byte], CInt]
    inline def apply(
        inline o: CFuncPtr4[Ptr[git_buf], CString, CInt, Ptr[Byte], CInt]
    ): git_url_resolve_cb = o

  type int32_t = scala.scalanative.unsafe.CInt
  object int32_t:
    val _tag: Tag[int32_t] = summon[Tag[scala.scalanative.unsafe.CInt]]

  opaque type int64_t = CLongLong
  object int64_t:
    given _tag: Tag[int64_t] = Tag.Long
    inline def apply(inline o: CLongLong): int64_t = o

  type size_t = scala.scalanative.unsafe.CSize
  object size_t:
    val _tag: Tag[size_t] = summon[Tag[scala.scalanative.unsafe.CSize]]

  type uint16_t = scala.scalanative.unsigned.UShort
  object uint16_t:
    val _tag: Tag[uint16_t] = summon[Tag[scala.scalanative.unsigned.UShort]]

  type uint32_t = scala.scalanative.unsigned.UInt
  object uint32_t:
    val _tag: Tag[uint32_t] = summon[Tag[scala.scalanative.unsigned.UInt]]

  opaque type uint64_t = CUnsignedLongLong
  object uint64_t:
    given _tag: Tag[uint64_t] = Tag.ULong
    inline def apply(inline o: CUnsignedLongLong): uint64_t = o
  opaque type LIBSSH2_SESSION = CStruct0
  object LIBSSH2_SESSION:
    given _tag: Tag[LIBSSH2_SESSION] = Tag.materializeCStruct0Tag

  opaque type LIBSSH2_USERAUTH_KBDINT_PROMPT = CStruct0
  object LIBSSH2_USERAUTH_KBDINT_PROMPT:
    given _tag: Tag[LIBSSH2_USERAUTH_KBDINT_PROMPT] = Tag.materializeCStruct0Tag

  opaque type LIBSSH2_USERAUTH_KBDINT_RESPONSE = CStruct0
  object LIBSSH2_USERAUTH_KBDINT_RESPONSE:
    given _tag: Tag[LIBSSH2_USERAUTH_KBDINT_RESPONSE] =
      Tag.materializeCStruct0Tag

  opaque type _LIBSSH2_SESSION = CStruct0
  object _LIBSSH2_SESSION:
    given _tag: Tag[_LIBSSH2_SESSION] = Tag.materializeCStruct0Tag

  opaque type _LIBSSH2_USERAUTH_KBDINT_PROMPT = CStruct0
  object _LIBSSH2_USERAUTH_KBDINT_PROMPT:
    given _tag: Tag[_LIBSSH2_USERAUTH_KBDINT_PROMPT] =
      Tag.materializeCStruct0Tag

  opaque type _LIBSSH2_USERAUTH_KBDINT_RESPONSE = CStruct0
  object _LIBSSH2_USERAUTH_KBDINT_RESPONSE:
    given _tag: Tag[_LIBSSH2_USERAUTH_KBDINT_RESPONSE] =
      Tag.materializeCStruct0Tag

  opaque type git_annotated_commit = CStruct0
  object git_annotated_commit:
    given _tag: Tag[git_annotated_commit] = Tag.materializeCStruct0Tag

  opaque type git_apply_options =
    CStruct5[CUnsignedInt, git_apply_delta_cb, git_apply_hunk_cb, Ptr[
      Byte
    ], CUnsignedInt]
  object git_apply_options:
    given _tag: Tag[git_apply_options] = Tag.materializeCStruct5Tag[
      CUnsignedInt,
      git_apply_delta_cb,
      git_apply_hunk_cb,
      Ptr[Byte],
      CUnsignedInt
    ]
    def apply()(using Zone): Ptr[git_apply_options] =
      scala.scalanative.unsafe.alloc[git_apply_options](1)
    def apply(
        version: CUnsignedInt,
        delta_cb: git_apply_delta_cb,
        hunk_cb: git_apply_hunk_cb,
        payload: Ptr[Byte],
        flags: CUnsignedInt
    )(using Zone): Ptr[git_apply_options] =
      val ____ptr = apply()
      (!____ptr).version = version
      (!____ptr).delta_cb = delta_cb
      (!____ptr).hunk_cb = hunk_cb
      (!____ptr).payload = payload
      (!____ptr).flags = flags
      ____ptr
    extension (struct: git_apply_options)
      def version: CUnsignedInt = struct._1
      def version_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def delta_cb: git_apply_delta_cb = struct._2
      def delta_cb_=(value: git_apply_delta_cb): Unit = !struct.at2 = value
      def hunk_cb: git_apply_hunk_cb = struct._3
      def hunk_cb_=(value: git_apply_hunk_cb): Unit = !struct.at3 = value
      def payload: Ptr[Byte] = struct._4
      def payload_=(value: Ptr[Byte]): Unit = !struct.at4 = value
      def flags: CUnsignedInt = struct._5
      def flags_=(value: CUnsignedInt): Unit = !struct.at5 = value

  opaque type git_attr_options =
    CStruct4[CUnsignedInt, CUnsignedInt, Ptr[git_oid], git_oid]
  object git_attr_options:
    given _tag: Tag[git_attr_options] = Tag
      .materializeCStruct4Tag[CUnsignedInt, CUnsignedInt, Ptr[git_oid], git_oid]
    def apply()(using Zone): Ptr[git_attr_options] =
      scala.scalanative.unsafe.alloc[git_attr_options](1)
    def apply(
        version: CUnsignedInt,
        flags: CUnsignedInt,
        commit_id: Ptr[git_oid],
        attr_commit_id: git_oid
    )(using Zone): Ptr[git_attr_options] =
      val ____ptr = apply()
      (!____ptr).version = version
      (!____ptr).flags = flags
      (!____ptr).commit_id = commit_id
      (!____ptr).attr_commit_id = attr_commit_id
      ____ptr
    extension (struct: git_attr_options)
      def version: CUnsignedInt = struct._1
      def version_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def flags: CUnsignedInt = struct._2
      def flags_=(value: CUnsignedInt): Unit = !struct.at2 = value
      def commit_id: Ptr[git_oid] = struct._3
      def commit_id_=(value: Ptr[git_oid]): Unit = !struct.at3 = value
      def attr_commit_id: git_oid = struct._4
      def attr_commit_id_=(value: git_oid): Unit = !struct.at4 = value

  opaque type git_blame = CStruct0
  object git_blame:
    given _tag: Tag[git_blame] = Tag.materializeCStruct0Tag

  opaque type git_blame_hunk = CStruct9[size_t, git_oid, size_t, Ptr[
    git_signature
  ], git_oid, CString, size_t, Ptr[git_signature], CChar]
  object git_blame_hunk:
    given _tag: Tag[git_blame_hunk] =
      Tag.materializeCStruct9Tag[size_t, git_oid, size_t, Ptr[
        git_signature
      ], git_oid, CString, size_t, Ptr[git_signature], CChar]
    def apply()(using Zone): Ptr[git_blame_hunk] =
      scala.scalanative.unsafe.alloc[git_blame_hunk](1)
    def apply(
        lines_in_hunk: size_t,
        final_commit_id: git_oid,
        final_start_line_number: size_t,
        final_signature: Ptr[git_signature],
        orig_commit_id: git_oid,
        orig_path: CString,
        orig_start_line_number: size_t,
        orig_signature: Ptr[git_signature],
        boundary: CChar
    )(using Zone): Ptr[git_blame_hunk] =
      val ____ptr = apply()
      (!____ptr).lines_in_hunk = lines_in_hunk
      (!____ptr).final_commit_id = final_commit_id
      (!____ptr).final_start_line_number = final_start_line_number
      (!____ptr).final_signature = final_signature
      (!____ptr).orig_commit_id = orig_commit_id
      (!____ptr).orig_path = orig_path
      (!____ptr).orig_start_line_number = orig_start_line_number
      (!____ptr).orig_signature = orig_signature
      (!____ptr).boundary = boundary
      ____ptr
    extension (struct: git_blame_hunk)
      def lines_in_hunk: size_t = struct._1
      def lines_in_hunk_=(value: size_t): Unit = !struct.at1 = value
      def final_commit_id: git_oid = struct._2
      def final_commit_id_=(value: git_oid): Unit = !struct.at2 = value
      def final_start_line_number: size_t = struct._3
      def final_start_line_number_=(value: size_t): Unit = !struct.at3 = value
      def final_signature: Ptr[git_signature] = struct._4
      def final_signature_=(value: Ptr[git_signature]): Unit = !struct.at4 =
        value
      def orig_commit_id: git_oid = struct._5
      def orig_commit_id_=(value: git_oid): Unit = !struct.at5 = value
      def orig_path: CString = struct._6
      def orig_path_=(value: CString): Unit = !struct.at6 = value
      def orig_start_line_number: size_t = struct._7
      def orig_start_line_number_=(value: size_t): Unit = !struct.at7 = value
      def orig_signature: Ptr[git_signature] = struct._8
      def orig_signature_=(value: Ptr[git_signature]): Unit = !struct.at8 =
        value
      def boundary: CChar = struct._9
      def boundary_=(value: CChar): Unit = !struct.at9 = value

  opaque type git_blame_options =
    CStruct7[CUnsignedInt, uint32_t, uint16_t, git_oid, git_oid, size_t, size_t]
  object git_blame_options:
    given _tag: Tag[git_blame_options] = Tag.materializeCStruct7Tag[
      CUnsignedInt,
      uint32_t,
      uint16_t,
      git_oid,
      git_oid,
      size_t,
      size_t
    ]
    def apply()(using Zone): Ptr[git_blame_options] =
      scala.scalanative.unsafe.alloc[git_blame_options](1)
    def apply(
        version: CUnsignedInt,
        flags: uint32_t,
        min_match_characters: uint16_t,
        newest_commit: git_oid,
        oldest_commit: git_oid,
        min_line: size_t,
        max_line: size_t
    )(using Zone): Ptr[git_blame_options] =
      val ____ptr = apply()
      (!____ptr).version = version
      (!____ptr).flags = flags
      (!____ptr).min_match_characters = min_match_characters
      (!____ptr).newest_commit = newest_commit
      (!____ptr).oldest_commit = oldest_commit
      (!____ptr).min_line = min_line
      (!____ptr).max_line = max_line
      ____ptr
    extension (struct: git_blame_options)
      def version: CUnsignedInt = struct._1
      def version_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def flags: uint32_t = struct._2
      def flags_=(value: uint32_t): Unit = !struct.at2 = value
      def min_match_characters: uint16_t = struct._3
      def min_match_characters_=(value: uint16_t): Unit = !struct.at3 = value
      def newest_commit: git_oid = struct._4
      def newest_commit_=(value: git_oid): Unit = !struct.at4 = value
      def oldest_commit: git_oid = struct._5
      def oldest_commit_=(value: git_oid): Unit = !struct.at5 = value
      def min_line: size_t = struct._6
      def min_line_=(value: size_t): Unit = !struct.at6 = value
      def max_line: size_t = struct._7
      def max_line_=(value: size_t): Unit = !struct.at7 = value

  opaque type git_blob = CStruct0
  object git_blob:
    given _tag: Tag[git_blob] = Tag.materializeCStruct0Tag

  opaque type git_blob_filter_options =
    CStruct4[CInt, uint32_t, Ptr[git_oid], git_oid]
  object git_blob_filter_options:
    given _tag: Tag[git_blob_filter_options] =
      Tag.materializeCStruct4Tag[CInt, uint32_t, Ptr[git_oid], git_oid]
    def apply()(using Zone): Ptr[git_blob_filter_options] =
      scala.scalanative.unsafe.alloc[git_blob_filter_options](1)
    def apply(
        version: CInt,
        flags: uint32_t,
        commit_id: Ptr[git_oid],
        attr_commit_id: git_oid
    )(using Zone): Ptr[git_blob_filter_options] =
      val ____ptr = apply()
      (!____ptr).version = version
      (!____ptr).flags = flags
      (!____ptr).commit_id = commit_id
      (!____ptr).attr_commit_id = attr_commit_id
      ____ptr
    extension (struct: git_blob_filter_options)
      def version: CInt = struct._1
      def version_=(value: CInt): Unit = !struct.at1 = value
      def flags: uint32_t = struct._2
      def flags_=(value: uint32_t): Unit = !struct.at2 = value
      def commit_id: Ptr[git_oid] = struct._3
      def commit_id_=(value: Ptr[git_oid]): Unit = !struct.at3 = value
      def attr_commit_id: git_oid = struct._4
      def attr_commit_id_=(value: git_oid): Unit = !struct.at4 = value

  opaque type git_branch_iterator = CStruct0
  object git_branch_iterator:
    given _tag: Tag[git_branch_iterator] = Tag.materializeCStruct0Tag

  opaque type git_buf = CStruct3[CString, size_t, size_t]
  object git_buf:
    given _tag: Tag[git_buf] =
      Tag.materializeCStruct3Tag[CString, size_t, size_t]
    def apply()(using Zone): Ptr[git_buf] =
      scala.scalanative.unsafe.alloc[git_buf](1)
    def apply(ptr: CString, reserved: size_t, size: size_t)(using
        Zone
    ): Ptr[git_buf] =
      val ____ptr = apply()
      (!____ptr).ptr = ptr
      (!____ptr).reserved = reserved
      (!____ptr).size = size
      ____ptr
    extension (struct: git_buf)
      def ptr: CString = struct._1
      def ptr_=(value: CString): Unit = !struct.at1 = value
      def reserved: size_t = struct._2
      def reserved_=(value: size_t): Unit = !struct.at2 = value
      def size: size_t = struct._3
      def size_=(value: size_t): Unit = !struct.at3 = value

  opaque type git_cert = CStruct1[git_cert_t]
  object git_cert:
    given _tag: Tag[git_cert] = Tag.materializeCStruct1Tag[git_cert_t]
    def apply()(using Zone): Ptr[git_cert] =
      scala.scalanative.unsafe.alloc[git_cert](1)
    def apply(cert_type: git_cert_t)(using Zone): Ptr[git_cert] =
      val ____ptr = apply()
      (!____ptr).cert_type = cert_type
      ____ptr
    extension (struct: git_cert)
      def cert_type: git_cert_t = struct._1
      def cert_type_=(value: git_cert_t): Unit = !struct.at1 = value

  opaque type git_cert_hostkey = CStruct8[
    git_cert,
    git_cert_ssh_t,
    CArray[CUnsignedChar, Nat.Digit2[Nat._1, Nat._6]],
    CArray[CUnsignedChar, Nat.Digit2[Nat._2, Nat._0]],
    CArray[CUnsignedChar, Nat.Digit2[Nat._3, Nat._2]],
    git_cert_ssh_raw_type_t,
    CString,
    size_t
  ]
  object git_cert_hostkey:
    given _tag: Tag[git_cert_hostkey] = Tag.materializeCStruct8Tag[
      git_cert,
      git_cert_ssh_t,
      CArray[CUnsignedChar, Nat.Digit2[Nat._1, Nat._6]],
      CArray[CUnsignedChar, Nat.Digit2[Nat._2, Nat._0]],
      CArray[CUnsignedChar, Nat.Digit2[Nat._3, Nat._2]],
      git_cert_ssh_raw_type_t,
      CString,
      size_t
    ]
    def apply()(using Zone): Ptr[git_cert_hostkey] =
      scala.scalanative.unsafe.alloc[git_cert_hostkey](1)
    def apply(
        parent: git_cert,
        `type`: git_cert_ssh_t,
        hash_md5: CArray[CUnsignedChar, Nat.Digit2[Nat._1, Nat._6]],
        hash_sha1: CArray[CUnsignedChar, Nat.Digit2[Nat._2, Nat._0]],
        hash_sha256: CArray[CUnsignedChar, Nat.Digit2[Nat._3, Nat._2]],
        raw_type: git_cert_ssh_raw_type_t,
        hostkey: CString,
        hostkey_len: size_t
    )(using Zone): Ptr[git_cert_hostkey] =
      val ____ptr = apply()
      (!____ptr).parent = parent
      (!____ptr).`type` = `type`
      (!____ptr).hash_md5 = hash_md5
      (!____ptr).hash_sha1 = hash_sha1
      (!____ptr).hash_sha256 = hash_sha256
      (!____ptr).raw_type = raw_type
      (!____ptr).hostkey = hostkey
      (!____ptr).hostkey_len = hostkey_len
      ____ptr
    extension (struct: git_cert_hostkey)
      def parent: git_cert = struct._1
      def parent_=(value: git_cert): Unit = !struct.at1 = value
      def `type`: git_cert_ssh_t = struct._2
      def type_=(value: git_cert_ssh_t): Unit = !struct.at2 = value
      def hash_md5: CArray[CUnsignedChar, Nat.Digit2[Nat._1, Nat._6]] =
        struct._3
      def hash_md5_=(
          value: CArray[CUnsignedChar, Nat.Digit2[Nat._1, Nat._6]]
      ): Unit = !struct.at3 = value
      def hash_sha1: CArray[CUnsignedChar, Nat.Digit2[Nat._2, Nat._0]] =
        struct._4
      def hash_sha1_=(
          value: CArray[CUnsignedChar, Nat.Digit2[Nat._2, Nat._0]]
      ): Unit = !struct.at4 = value
      def hash_sha256: CArray[CUnsignedChar, Nat.Digit2[Nat._3, Nat._2]] =
        struct._5
      def hash_sha256_=(
          value: CArray[CUnsignedChar, Nat.Digit2[Nat._3, Nat._2]]
      ): Unit = !struct.at5 = value
      def raw_type: git_cert_ssh_raw_type_t = struct._6
      def raw_type_=(value: git_cert_ssh_raw_type_t): Unit = !struct.at6 = value
      def hostkey: CString = struct._7
      def hostkey_=(value: CString): Unit = !struct.at7 = value
      def hostkey_len: size_t = struct._8
      def hostkey_len_=(value: size_t): Unit = !struct.at8 = value

  opaque type git_cert_x509 = CStruct3[git_cert, Ptr[Byte], size_t]
  object git_cert_x509:
    given _tag: Tag[git_cert_x509] =
      Tag.materializeCStruct3Tag[git_cert, Ptr[Byte], size_t]
    def apply()(using Zone): Ptr[git_cert_x509] =
      scala.scalanative.unsafe.alloc[git_cert_x509](1)
    def apply(parent: git_cert, data: Ptr[Byte], len: size_t)(using
        Zone
    ): Ptr[git_cert_x509] =
      val ____ptr = apply()
      (!____ptr).parent = parent
      (!____ptr).data = data
      (!____ptr).len = len
      ____ptr
    extension (struct: git_cert_x509)
      def parent: git_cert = struct._1
      def parent_=(value: git_cert): Unit = !struct.at1 = value
      def data: Ptr[Byte] = struct._2
      def data_=(value: Ptr[Byte]): Unit = !struct.at2 = value
      def len: size_t = struct._3
      def len_=(value: size_t): Unit = !struct.at3 = value

  opaque type git_checkout_options = CStruct20[
    CUnsignedInt,
    CUnsignedInt,
    CInt,
    CUnsignedInt,
    CUnsignedInt,
    CInt,
    CUnsignedInt,
    git_checkout_notify_cb,
    Ptr[Byte],
    git_checkout_progress_cb,
    Ptr[Byte],
    git_strarray,
    Ptr[git_tree],
    Ptr[git_index],
    CString,
    CString,
    CString,
    CString,
    git_checkout_perfdata_cb,
    Ptr[Byte]
  ]
  object git_checkout_options:
    given _tag: Tag[git_checkout_options] = Tag.materializeCStruct20Tag[
      CUnsignedInt,
      CUnsignedInt,
      CInt,
      CUnsignedInt,
      CUnsignedInt,
      CInt,
      CUnsignedInt,
      git_checkout_notify_cb,
      Ptr[Byte],
      git_checkout_progress_cb,
      Ptr[Byte],
      git_strarray,
      Ptr[git_tree],
      Ptr[git_index],
      CString,
      CString,
      CString,
      CString,
      git_checkout_perfdata_cb,
      Ptr[Byte]
    ]
    def apply()(using Zone): Ptr[git_checkout_options] =
      scala.scalanative.unsafe.alloc[git_checkout_options](1)
    def apply(
        version: CUnsignedInt,
        checkout_strategy: CUnsignedInt,
        disable_filters: CInt,
        dir_mode: CUnsignedInt,
        file_mode: CUnsignedInt,
        file_open_flags: CInt,
        notify_flags: CUnsignedInt,
        notify_cb: git_checkout_notify_cb,
        notify_payload: Ptr[Byte],
        progress_cb: git_checkout_progress_cb,
        progress_payload: Ptr[Byte],
        paths: git_strarray,
        baseline: Ptr[git_tree],
        baseline_index: Ptr[git_index],
        target_directory: CString,
        ancestor_label: CString,
        our_label: CString,
        their_label: CString,
        perfdata_cb: git_checkout_perfdata_cb,
        perfdata_payload: Ptr[Byte]
    )(using Zone): Ptr[git_checkout_options] =
      val ____ptr = apply()
      (!____ptr).version = version
      (!____ptr).checkout_strategy = checkout_strategy
      (!____ptr).disable_filters = disable_filters
      (!____ptr).dir_mode = dir_mode
      (!____ptr).file_mode = file_mode
      (!____ptr).file_open_flags = file_open_flags
      (!____ptr).notify_flags = notify_flags
      (!____ptr).notify_cb = notify_cb
      (!____ptr).notify_payload = notify_payload
      (!____ptr).progress_cb = progress_cb
      (!____ptr).progress_payload = progress_payload
      (!____ptr).paths = paths
      (!____ptr).baseline = baseline
      (!____ptr).baseline_index = baseline_index
      (!____ptr).target_directory = target_directory
      (!____ptr).ancestor_label = ancestor_label
      (!____ptr).our_label = our_label
      (!____ptr).their_label = their_label
      (!____ptr).perfdata_cb = perfdata_cb
      (!____ptr).perfdata_payload = perfdata_payload
      ____ptr
    extension (struct: git_checkout_options)
      def version: CUnsignedInt = struct._1
      def version_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def checkout_strategy: CUnsignedInt = struct._2
      def checkout_strategy_=(value: CUnsignedInt): Unit = !struct.at2 = value
      def disable_filters: CInt = struct._3
      def disable_filters_=(value: CInt): Unit = !struct.at3 = value
      def dir_mode: CUnsignedInt = struct._4
      def dir_mode_=(value: CUnsignedInt): Unit = !struct.at4 = value
      def file_mode: CUnsignedInt = struct._5
      def file_mode_=(value: CUnsignedInt): Unit = !struct.at5 = value
      def file_open_flags: CInt = struct._6
      def file_open_flags_=(value: CInt): Unit = !struct.at6 = value
      def notify_flags: CUnsignedInt = struct._7
      def notify_flags_=(value: CUnsignedInt): Unit = !struct.at7 = value
      def notify_cb: git_checkout_notify_cb = struct._8
      def notify_cb_=(value: git_checkout_notify_cb): Unit = !struct.at8 = value
      def notify_payload: Ptr[Byte] = struct._9
      def notify_payload_=(value: Ptr[Byte]): Unit = !struct.at9 = value
      def progress_cb: git_checkout_progress_cb = struct._10
      def progress_cb_=(value: git_checkout_progress_cb): Unit = !struct.at10 =
        value
      def progress_payload: Ptr[Byte] = struct._11
      def progress_payload_=(value: Ptr[Byte]): Unit = !struct.at11 = value
      def paths: git_strarray = struct._12
      def paths_=(value: git_strarray): Unit = !struct.at12 = value
      def baseline: Ptr[git_tree] = struct._13
      def baseline_=(value: Ptr[git_tree]): Unit = !struct.at13 = value
      def baseline_index: Ptr[git_index] = struct._14
      def baseline_index_=(value: Ptr[git_index]): Unit = !struct.at14 = value
      def target_directory: CString = struct._15
      def target_directory_=(value: CString): Unit = !struct.at15 = value
      def ancestor_label: CString = struct._16
      def ancestor_label_=(value: CString): Unit = !struct.at16 = value
      def our_label: CString = struct._17
      def our_label_=(value: CString): Unit = !struct.at17 = value
      def their_label: CString = struct._18
      def their_label_=(value: CString): Unit = !struct.at18 = value
      def perfdata_cb: git_checkout_perfdata_cb = struct._19
      def perfdata_cb_=(value: git_checkout_perfdata_cb): Unit = !struct.at19 =
        value
      def perfdata_payload: Ptr[Byte] = struct._20
      def perfdata_payload_=(value: Ptr[Byte]): Unit = !struct.at20 = value

  opaque type git_checkout_perfdata = CStruct3[size_t, size_t, size_t]
  object git_checkout_perfdata:
    given _tag: Tag[git_checkout_perfdata] =
      Tag.materializeCStruct3Tag[size_t, size_t, size_t]
    def apply()(using Zone): Ptr[git_checkout_perfdata] =
      scala.scalanative.unsafe.alloc[git_checkout_perfdata](1)
    def apply(mkdir_calls: size_t, stat_calls: size_t, chmod_calls: size_t)(
        using Zone
    ): Ptr[git_checkout_perfdata] =
      val ____ptr = apply()
      (!____ptr).mkdir_calls = mkdir_calls
      (!____ptr).stat_calls = stat_calls
      (!____ptr).chmod_calls = chmod_calls
      ____ptr
    extension (struct: git_checkout_perfdata)
      def mkdir_calls: size_t = struct._1
      def mkdir_calls_=(value: size_t): Unit = !struct.at1 = value
      def stat_calls: size_t = struct._2
      def stat_calls_=(value: size_t): Unit = !struct.at2 = value
      def chmod_calls: size_t = struct._3
      def chmod_calls_=(value: size_t): Unit = !struct.at3 = value

  opaque type git_cherrypick_options = CStruct4[
    CUnsignedInt,
    CUnsignedInt,
    git_merge_options,
    git_checkout_options
  ]
  object git_cherrypick_options:
    given _tag: Tag[git_cherrypick_options] = Tag.materializeCStruct4Tag[
      CUnsignedInt,
      CUnsignedInt,
      git_merge_options,
      git_checkout_options
    ]
    def apply()(using Zone): Ptr[git_cherrypick_options] =
      scala.scalanative.unsafe.alloc[git_cherrypick_options](1)
    def apply(
        version: CUnsignedInt,
        mainline: CUnsignedInt,
        merge_opts: git_merge_options,
        checkout_opts: git_checkout_options
    )(using Zone): Ptr[git_cherrypick_options] =
      val ____ptr = apply()
      (!____ptr).version = version
      (!____ptr).mainline = mainline
      (!____ptr).merge_opts = merge_opts
      (!____ptr).checkout_opts = checkout_opts
      ____ptr
    extension (struct: git_cherrypick_options)
      def version: CUnsignedInt = struct._1
      def version_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def mainline: CUnsignedInt = struct._2
      def mainline_=(value: CUnsignedInt): Unit = !struct.at2 = value
      def merge_opts: git_merge_options = struct._3
      def merge_opts_=(value: git_merge_options): Unit = !struct.at3 = value
      def checkout_opts: git_checkout_options = struct._4
      def checkout_opts_=(value: git_checkout_options): Unit = !struct.at4 =
        value

  opaque type git_clone_options = CStruct10[
    CUnsignedInt,
    git_checkout_options,
    git_fetch_options,
    CInt,
    git_clone_local_t,
    CString,
    git_repository_create_cb,
    Ptr[Byte],
    git_remote_create_cb,
    Ptr[Byte]
  ]
  object git_clone_options:
    given _tag: Tag[git_clone_options] = Tag.materializeCStruct10Tag[
      CUnsignedInt,
      git_checkout_options,
      git_fetch_options,
      CInt,
      git_clone_local_t,
      CString,
      git_repository_create_cb,
      Ptr[Byte],
      git_remote_create_cb,
      Ptr[Byte]
    ]
    def apply()(using Zone): Ptr[git_clone_options] =
      scala.scalanative.unsafe.alloc[git_clone_options](1)
    def apply(
        version: CUnsignedInt,
        checkout_opts: git_checkout_options,
        fetch_opts: git_fetch_options,
        bare: CInt,
        local: git_clone_local_t,
        checkout_branch: CString,
        repository_cb: git_repository_create_cb,
        repository_cb_payload: Ptr[Byte],
        remote_cb: git_remote_create_cb,
        remote_cb_payload: Ptr[Byte]
    )(using Zone): Ptr[git_clone_options] =
      val ____ptr = apply()
      (!____ptr).version = version
      (!____ptr).checkout_opts = checkout_opts
      (!____ptr).fetch_opts = fetch_opts
      (!____ptr).bare = bare
      (!____ptr).local = local
      (!____ptr).checkout_branch = checkout_branch
      (!____ptr).repository_cb = repository_cb
      (!____ptr).repository_cb_payload = repository_cb_payload
      (!____ptr).remote_cb = remote_cb
      (!____ptr).remote_cb_payload = remote_cb_payload
      ____ptr
    extension (struct: git_clone_options)
      def version: CUnsignedInt = struct._1
      def version_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def checkout_opts: git_checkout_options = struct._2
      def checkout_opts_=(value: git_checkout_options): Unit = !struct.at2 =
        value
      def fetch_opts: git_fetch_options = struct._3
      def fetch_opts_=(value: git_fetch_options): Unit = !struct.at3 = value
      def bare: CInt = struct._4
      def bare_=(value: CInt): Unit = !struct.at4 = value
      def local: git_clone_local_t = struct._5
      def local_=(value: git_clone_local_t): Unit = !struct.at5 = value
      def checkout_branch: CString = struct._6
      def checkout_branch_=(value: CString): Unit = !struct.at6 = value
      def repository_cb: git_repository_create_cb = struct._7
      def repository_cb_=(value: git_repository_create_cb): Unit = !struct.at7 =
        value
      def repository_cb_payload: Ptr[Byte] = struct._8
      def repository_cb_payload_=(value: Ptr[Byte]): Unit = !struct.at8 = value
      def remote_cb: git_remote_create_cb = struct._9
      def remote_cb_=(value: git_remote_create_cb): Unit = !struct.at9 = value
      def remote_cb_payload: Ptr[Byte] = struct._10
      def remote_cb_payload_=(value: Ptr[Byte]): Unit = !struct.at10 = value

  opaque type git_commit = CStruct0
  object git_commit:
    given _tag: Tag[git_commit] = Tag.materializeCStruct0Tag

  opaque type git_commit_graph = CStruct0
  object git_commit_graph:
    given _tag: Tag[git_commit_graph] = Tag.materializeCStruct0Tag

  opaque type git_commit_graph_writer = CStruct0
  object git_commit_graph_writer:
    given _tag: Tag[git_commit_graph_writer] = Tag.materializeCStruct0Tag

  opaque type git_config = CStruct0
  object git_config:
    given _tag: Tag[git_config] = Tag.materializeCStruct0Tag

  opaque type git_config_backend = CStruct0
  object git_config_backend:
    given _tag: Tag[git_config_backend] = Tag.materializeCStruct0Tag

  opaque type git_config_entry =
    CStruct6[CString, CString, CUnsignedInt, git_config_level_t, CFuncPtr1[Ptr[
      Byte
    ], Unit], Ptr[Byte]]
  object git_config_entry:
    given _tag: Tag[git_config_entry] = Tag.materializeCStruct6Tag[
      CString,
      CString,
      CUnsignedInt,
      git_config_level_t,
      CFuncPtr1[Ptr[Byte], Unit],
      Ptr[Byte]
    ]
    def apply()(using Zone): Ptr[git_config_entry] =
      scala.scalanative.unsafe.alloc[git_config_entry](1)
    def apply(
        name: CString,
        value: CString,
        include_depth: CUnsignedInt,
        level: git_config_level_t,
        free: CFuncPtr1[Ptr[git_config_entry], Unit],
        payload: Ptr[Byte]
    )(using Zone): Ptr[git_config_entry] =
      val ____ptr = apply()
      (!____ptr).name = name
      (!____ptr).value = value
      (!____ptr).include_depth = include_depth
      (!____ptr).level = level
      (!____ptr).free = free
      (!____ptr).payload = payload
      ____ptr
    extension (struct: git_config_entry)
      def name: CString = struct._1
      def name_=(value: CString): Unit = !struct.at1 = value
      def value: CString = struct._2
      def value_=(value: CString): Unit = !struct.at2 = value
      def include_depth: CUnsignedInt = struct._3
      def include_depth_=(value: CUnsignedInt): Unit = !struct.at3 = value
      def level: git_config_level_t = struct._4
      def level_=(value: git_config_level_t): Unit = !struct.at4 = value
      def free: CFuncPtr1[Ptr[git_config_entry], Unit] =
        struct._5.asInstanceOf[CFuncPtr1[Ptr[git_config_entry], Unit]]
      def free_=(value: CFuncPtr1[Ptr[git_config_entry], Unit]): Unit =
        !struct.at5 = value.asInstanceOf[CFuncPtr1[Ptr[Byte], Unit]]
      def payload: Ptr[Byte] = struct._6
      def payload_=(value: Ptr[Byte]): Unit = !struct.at6 = value

  opaque type git_config_iterator = CStruct0
  object git_config_iterator:
    given _tag: Tag[git_config_iterator] = Tag.materializeCStruct0Tag

  opaque type git_configmap = CStruct3[git_configmap_t, CString, CInt]
  object git_configmap:
    given _tag: Tag[git_configmap] =
      Tag.materializeCStruct3Tag[git_configmap_t, CString, CInt]
    def apply()(using Zone): Ptr[git_configmap] =
      scala.scalanative.unsafe.alloc[git_configmap](1)
    def apply(`type`: git_configmap_t, str_match: CString, map_value: CInt)(
        using Zone
    ): Ptr[git_configmap] =
      val ____ptr = apply()
      (!____ptr).`type` = `type`
      (!____ptr).str_match = str_match
      (!____ptr).map_value = map_value
      ____ptr
    extension (struct: git_configmap)
      def `type`: git_configmap_t = struct._1
      def type_=(value: git_configmap_t): Unit = !struct.at1 = value
      def str_match: CString = struct._2
      def str_match_=(value: CString): Unit = !struct.at2 = value
      def map_value: CInt = struct._3
      def map_value_=(value: CInt): Unit = !struct.at3 = value

  opaque type git_credential =
    CStruct2[git_credential_t, CFuncPtr1[Ptr[Byte], Unit]]
  object git_credential:
    given _tag: Tag[git_credential] =
      Tag.materializeCStruct2Tag[git_credential_t, CFuncPtr1[Ptr[Byte], Unit]]
    def apply()(using Zone): Ptr[git_credential] =
      scala.scalanative.unsafe.alloc[git_credential](1)
    def apply(
        credtype: git_credential_t,
        free: CFuncPtr1[Ptr[git_credential], Unit]
    )(using Zone): Ptr[git_credential] =
      val ____ptr = apply()
      (!____ptr).credtype = credtype
      (!____ptr).free = free
      ____ptr
    extension (struct: git_credential)
      def credtype: git_credential_t = struct._1
      def credtype_=(value: git_credential_t): Unit = !struct.at1 = value
      def free: CFuncPtr1[Ptr[git_credential], Unit] =
        struct._2.asInstanceOf[CFuncPtr1[Ptr[git_credential], Unit]]
      def free_=(value: CFuncPtr1[Ptr[git_credential], Unit]): Unit =
        !struct.at2 = value.asInstanceOf[CFuncPtr1[Ptr[Byte], Unit]]

  opaque type git_credential_default =
    CStruct2[git_credential_t, CFuncPtr1[Ptr[Byte], Unit]]
  object git_credential_default:
    given _tag: Tag[git_credential_default] =
      Tag.materializeCStruct2Tag[git_credential_t, CFuncPtr1[Ptr[Byte], Unit]]
    def apply()(using Zone): Ptr[git_credential_default] =
      scala.scalanative.unsafe.alloc[git_credential_default](1)
    def apply(
        credtype: git_credential_t,
        free: CFuncPtr1[Ptr[git_credential], Unit]
    )(using Zone): Ptr[git_credential_default] =
      val ____ptr = apply()
      (!____ptr).credtype = credtype
      (!____ptr).free = free
      ____ptr
    extension (struct: git_credential_default)
      def credtype: git_credential_t = struct._1
      def credtype_=(value: git_credential_t): Unit = !struct.at1 = value
      def free: CFuncPtr1[Ptr[git_credential], Unit] =
        struct._2.asInstanceOf[CFuncPtr1[Ptr[git_credential], Unit]]
      def free_=(value: CFuncPtr1[Ptr[git_credential], Unit]): Unit =
        !struct.at2 = value.asInstanceOf[CFuncPtr1[Ptr[Byte], Unit]]

  opaque type git_credential_ssh_custom = CStruct6[
    git_credential,
    CString,
    CString,
    size_t,
    git_credential_sign_cb,
    Ptr[Byte]
  ]
  object git_credential_ssh_custom:
    given _tag: Tag[git_credential_ssh_custom] = Tag.materializeCStruct6Tag[
      git_credential,
      CString,
      CString,
      size_t,
      git_credential_sign_cb,
      Ptr[Byte]
    ]
    def apply()(using Zone): Ptr[git_credential_ssh_custom] =
      scala.scalanative.unsafe.alloc[git_credential_ssh_custom](1)
    def apply(
        parent: git_credential,
        username: CString,
        publickey: CString,
        publickey_len: size_t,
        sign_callback: git_credential_sign_cb,
        payload: Ptr[Byte]
    )(using Zone): Ptr[git_credential_ssh_custom] =
      val ____ptr = apply()
      (!____ptr).parent = parent
      (!____ptr).username = username
      (!____ptr).publickey = publickey
      (!____ptr).publickey_len = publickey_len
      (!____ptr).sign_callback = sign_callback
      (!____ptr).payload = payload
      ____ptr
    extension (struct: git_credential_ssh_custom)
      def parent: git_credential = struct._1
      def parent_=(value: git_credential): Unit = !struct.at1 = value
      def username: CString = struct._2
      def username_=(value: CString): Unit = !struct.at2 = value
      def publickey: CString = struct._3
      def publickey_=(value: CString): Unit = !struct.at3 = value
      def publickey_len: size_t = struct._4
      def publickey_len_=(value: size_t): Unit = !struct.at4 = value
      def sign_callback: git_credential_sign_cb = struct._5
      def sign_callback_=(value: git_credential_sign_cb): Unit = !struct.at5 =
        value
      def payload: Ptr[Byte] = struct._6
      def payload_=(value: Ptr[Byte]): Unit = !struct.at6 = value

  opaque type git_credential_ssh_interactive =
    CStruct4[git_credential, CString, git_credential_ssh_interactive_cb, Ptr[
      Byte
    ]]
  object git_credential_ssh_interactive:
    given _tag: Tag[git_credential_ssh_interactive] =
      Tag.materializeCStruct4Tag[
        git_credential,
        CString,
        git_credential_ssh_interactive_cb,
        Ptr[Byte]
      ]
    def apply()(using Zone): Ptr[git_credential_ssh_interactive] =
      scala.scalanative.unsafe.alloc[git_credential_ssh_interactive](1)
    def apply(
        parent: git_credential,
        username: CString,
        prompt_callback: git_credential_ssh_interactive_cb,
        payload: Ptr[Byte]
    )(using Zone): Ptr[git_credential_ssh_interactive] =
      val ____ptr = apply()
      (!____ptr).parent = parent
      (!____ptr).username = username
      (!____ptr).prompt_callback = prompt_callback
      (!____ptr).payload = payload
      ____ptr
    extension (struct: git_credential_ssh_interactive)
      def parent: git_credential = struct._1
      def parent_=(value: git_credential): Unit = !struct.at1 = value
      def username: CString = struct._2
      def username_=(value: CString): Unit = !struct.at2 = value
      def prompt_callback: git_credential_ssh_interactive_cb = struct._3
      def prompt_callback_=(value: git_credential_ssh_interactive_cb): Unit =
        !struct.at3 = value
      def payload: Ptr[Byte] = struct._4
      def payload_=(value: Ptr[Byte]): Unit = !struct.at4 = value

  opaque type git_credential_ssh_key =
    CStruct5[git_credential, CString, CString, CString, CString]
  object git_credential_ssh_key:
    given _tag: Tag[git_credential_ssh_key] = Tag.materializeCStruct5Tag[
      git_credential,
      CString,
      CString,
      CString,
      CString
    ]
    def apply()(using Zone): Ptr[git_credential_ssh_key] =
      scala.scalanative.unsafe.alloc[git_credential_ssh_key](1)
    def apply(
        parent: git_credential,
        username: CString,
        publickey: CString,
        privatekey: CString,
        passphrase: CString
    )(using Zone): Ptr[git_credential_ssh_key] =
      val ____ptr = apply()
      (!____ptr).parent = parent
      (!____ptr).username = username
      (!____ptr).publickey = publickey
      (!____ptr).privatekey = privatekey
      (!____ptr).passphrase = passphrase
      ____ptr
    extension (struct: git_credential_ssh_key)
      def parent: git_credential = struct._1
      def parent_=(value: git_credential): Unit = !struct.at1 = value
      def username: CString = struct._2
      def username_=(value: CString): Unit = !struct.at2 = value
      def publickey: CString = struct._3
      def publickey_=(value: CString): Unit = !struct.at3 = value
      def privatekey: CString = struct._4
      def privatekey_=(value: CString): Unit = !struct.at4 = value
      def passphrase: CString = struct._5
      def passphrase_=(value: CString): Unit = !struct.at5 = value

  opaque type git_credential_username =
    CStruct2[git_credential, CArray[CChar, Nat._1]]
  object git_credential_username:
    given _tag: Tag[git_credential_username] =
      Tag.materializeCStruct2Tag[git_credential, CArray[CChar, Nat._1]]
    def apply()(using Zone): Ptr[git_credential_username] =
      scala.scalanative.unsafe.alloc[git_credential_username](1)
    def apply(parent: git_credential, username: CArray[CChar, Nat._1])(using
        Zone
    ): Ptr[git_credential_username] =
      val ____ptr = apply()
      (!____ptr).parent = parent
      (!____ptr).username = username
      ____ptr
    extension (struct: git_credential_username)
      def parent: git_credential = struct._1
      def parent_=(value: git_credential): Unit = !struct.at1 = value
      def username: CArray[CChar, Nat._1] = struct._2
      def username_=(value: CArray[CChar, Nat._1]): Unit = !struct.at2 = value

  opaque type git_credential_userpass_payload = CStruct2[CString, CString]
  object git_credential_userpass_payload:
    given _tag: Tag[git_credential_userpass_payload] =
      Tag.materializeCStruct2Tag[CString, CString]
    def apply()(using Zone): Ptr[git_credential_userpass_payload] =
      scala.scalanative.unsafe.alloc[git_credential_userpass_payload](1)
    def apply(username: CString, password: CString)(using
        Zone
    ): Ptr[git_credential_userpass_payload] =
      val ____ptr = apply()
      (!____ptr).username = username
      (!____ptr).password = password
      ____ptr
    extension (struct: git_credential_userpass_payload)
      def username: CString = struct._1
      def username_=(value: CString): Unit = !struct.at1 = value
      def password: CString = struct._2
      def password_=(value: CString): Unit = !struct.at2 = value

  opaque type git_credential_userpass_plaintext =
    CStruct3[git_credential, CString, CString]
  object git_credential_userpass_plaintext:
    given _tag: Tag[git_credential_userpass_plaintext] =
      Tag.materializeCStruct3Tag[git_credential, CString, CString]
    def apply()(using Zone): Ptr[git_credential_userpass_plaintext] =
      scala.scalanative.unsafe.alloc[git_credential_userpass_plaintext](1)
    def apply(parent: git_credential, username: CString, password: CString)(
        using Zone
    ): Ptr[git_credential_userpass_plaintext] =
      val ____ptr = apply()
      (!____ptr).parent = parent
      (!____ptr).username = username
      (!____ptr).password = password
      ____ptr
    extension (struct: git_credential_userpass_plaintext)
      def parent: git_credential = struct._1
      def parent_=(value: git_credential): Unit = !struct.at1 = value
      def username: CString = struct._2
      def username_=(value: CString): Unit = !struct.at2 = value
      def password: CString = struct._3
      def password_=(value: CString): Unit = !struct.at3 = value

  opaque type git_describe_format_options =
    CStruct4[CUnsignedInt, CUnsignedInt, CInt, CString]
  object git_describe_format_options:
    given _tag: Tag[git_describe_format_options] =
      Tag.materializeCStruct4Tag[CUnsignedInt, CUnsignedInt, CInt, CString]
    def apply()(using Zone): Ptr[git_describe_format_options] =
      scala.scalanative.unsafe.alloc[git_describe_format_options](1)
    def apply(
        version: CUnsignedInt,
        abbreviated_size: CUnsignedInt,
        always_use_long_format: CInt,
        dirty_suffix: CString
    )(using Zone): Ptr[git_describe_format_options] =
      val ____ptr = apply()
      (!____ptr).version = version
      (!____ptr).abbreviated_size = abbreviated_size
      (!____ptr).always_use_long_format = always_use_long_format
      (!____ptr).dirty_suffix = dirty_suffix
      ____ptr
    extension (struct: git_describe_format_options)
      def version: CUnsignedInt = struct._1
      def version_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def abbreviated_size: CUnsignedInt = struct._2
      def abbreviated_size_=(value: CUnsignedInt): Unit = !struct.at2 = value
      def always_use_long_format: CInt = struct._3
      def always_use_long_format_=(value: CInt): Unit = !struct.at3 = value
      def dirty_suffix: CString = struct._4
      def dirty_suffix_=(value: CString): Unit = !struct.at4 = value

  opaque type git_describe_options =
    CStruct6[CUnsignedInt, CUnsignedInt, CUnsignedInt, CString, CInt, CInt]
  object git_describe_options:
    given _tag: Tag[git_describe_options] = Tag.materializeCStruct6Tag[
      CUnsignedInt,
      CUnsignedInt,
      CUnsignedInt,
      CString,
      CInt,
      CInt
    ]
    def apply()(using Zone): Ptr[git_describe_options] =
      scala.scalanative.unsafe.alloc[git_describe_options](1)
    def apply(
        version: CUnsignedInt,
        max_candidates_tags: CUnsignedInt,
        describe_strategy: CUnsignedInt,
        pattern: CString,
        only_follow_first_parent: CInt,
        show_commit_oid_as_fallback: CInt
    )(using Zone): Ptr[git_describe_options] =
      val ____ptr = apply()
      (!____ptr).version = version
      (!____ptr).max_candidates_tags = max_candidates_tags
      (!____ptr).describe_strategy = describe_strategy
      (!____ptr).pattern = pattern
      (!____ptr).only_follow_first_parent = only_follow_first_parent
      (!____ptr).show_commit_oid_as_fallback = show_commit_oid_as_fallback
      ____ptr
    extension (struct: git_describe_options)
      def version: CUnsignedInt = struct._1
      def version_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def max_candidates_tags: CUnsignedInt = struct._2
      def max_candidates_tags_=(value: CUnsignedInt): Unit = !struct.at2 = value
      def describe_strategy: CUnsignedInt = struct._3
      def describe_strategy_=(value: CUnsignedInt): Unit = !struct.at3 = value
      def pattern: CString = struct._4
      def pattern_=(value: CString): Unit = !struct.at4 = value
      def only_follow_first_parent: CInt = struct._5
      def only_follow_first_parent_=(value: CInt): Unit = !struct.at5 = value
      def show_commit_oid_as_fallback: CInt = struct._6
      def show_commit_oid_as_fallback_=(value: CInt): Unit = !struct.at6 = value

  opaque type git_describe_result = CStruct0
  object git_describe_result:
    given _tag: Tag[git_describe_result] = Tag.materializeCStruct0Tag

  opaque type git_diff = CStruct0
  object git_diff:
    given _tag: Tag[git_diff] = Tag.materializeCStruct0Tag

  opaque type git_diff_binary =
    CStruct3[CUnsignedInt, git_diff_binary_file, git_diff_binary_file]
  object git_diff_binary:
    given _tag: Tag[git_diff_binary] = Tag.materializeCStruct3Tag[
      CUnsignedInt,
      git_diff_binary_file,
      git_diff_binary_file
    ]
    def apply()(using Zone): Ptr[git_diff_binary] =
      scala.scalanative.unsafe.alloc[git_diff_binary](1)
    def apply(
        contains_data: CUnsignedInt,
        old_file: git_diff_binary_file,
        new_file: git_diff_binary_file
    )(using Zone): Ptr[git_diff_binary] =
      val ____ptr = apply()
      (!____ptr).contains_data = contains_data
      (!____ptr).old_file = old_file
      (!____ptr).new_file = new_file
      ____ptr
    extension (struct: git_diff_binary)
      def contains_data: CUnsignedInt = struct._1
      def contains_data_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def old_file: git_diff_binary_file = struct._2
      def old_file_=(value: git_diff_binary_file): Unit = !struct.at2 = value
      def new_file: git_diff_binary_file = struct._3
      def new_file_=(value: git_diff_binary_file): Unit = !struct.at3 = value

  opaque type git_diff_binary_file =
    CStruct4[git_diff_binary_t, CString, size_t, size_t]
  object git_diff_binary_file:
    given _tag: Tag[git_diff_binary_file] =
      Tag.materializeCStruct4Tag[git_diff_binary_t, CString, size_t, size_t]
    def apply()(using Zone): Ptr[git_diff_binary_file] =
      scala.scalanative.unsafe.alloc[git_diff_binary_file](1)
    def apply(
        `type`: git_diff_binary_t,
        data: CString,
        datalen: size_t,
        inflatedlen: size_t
    )(using Zone): Ptr[git_diff_binary_file] =
      val ____ptr = apply()
      (!____ptr).`type` = `type`
      (!____ptr).data = data
      (!____ptr).datalen = datalen
      (!____ptr).inflatedlen = inflatedlen
      ____ptr
    extension (struct: git_diff_binary_file)
      def `type`: git_diff_binary_t = struct._1
      def type_=(value: git_diff_binary_t): Unit = !struct.at1 = value
      def data: CString = struct._2
      def data_=(value: CString): Unit = !struct.at2 = value
      def datalen: size_t = struct._3
      def datalen_=(value: size_t): Unit = !struct.at3 = value
      def inflatedlen: size_t = struct._4
      def inflatedlen_=(value: size_t): Unit = !struct.at4 = value

  opaque type git_diff_delta = CStruct6[
    git_delta_t,
    uint32_t,
    uint16_t,
    uint16_t,
    git_diff_file,
    git_diff_file
  ]
  object git_diff_delta:
    given _tag: Tag[git_diff_delta] = Tag.materializeCStruct6Tag[
      git_delta_t,
      uint32_t,
      uint16_t,
      uint16_t,
      git_diff_file,
      git_diff_file
    ]
    def apply()(using Zone): Ptr[git_diff_delta] =
      scala.scalanative.unsafe.alloc[git_diff_delta](1)
    def apply(
        status: git_delta_t,
        flags: uint32_t,
        similarity: uint16_t,
        nfiles: uint16_t,
        old_file: git_diff_file,
        new_file: git_diff_file
    )(using Zone): Ptr[git_diff_delta] =
      val ____ptr = apply()
      (!____ptr).status = status
      (!____ptr).flags = flags
      (!____ptr).similarity = similarity
      (!____ptr).nfiles = nfiles
      (!____ptr).old_file = old_file
      (!____ptr).new_file = new_file
      ____ptr
    extension (struct: git_diff_delta)
      def status: git_delta_t = struct._1
      def status_=(value: git_delta_t): Unit = !struct.at1 = value
      def flags: uint32_t = struct._2
      def flags_=(value: uint32_t): Unit = !struct.at2 = value
      def similarity: uint16_t = struct._3
      def similarity_=(value: uint16_t): Unit = !struct.at3 = value
      def nfiles: uint16_t = struct._4
      def nfiles_=(value: uint16_t): Unit = !struct.at4 = value
      def old_file: git_diff_file = struct._5
      def old_file_=(value: git_diff_file): Unit = !struct.at5 = value
      def new_file: git_diff_file = struct._6
      def new_file_=(value: git_diff_file): Unit = !struct.at6 = value

  opaque type git_diff_file =
    CStruct6[git_oid, CString, git_object_size_t, uint32_t, uint16_t, uint16_t]
  object git_diff_file:
    given _tag: Tag[git_diff_file] = Tag.materializeCStruct6Tag[
      git_oid,
      CString,
      git_object_size_t,
      uint32_t,
      uint16_t,
      uint16_t
    ]
    def apply()(using Zone): Ptr[git_diff_file] =
      scala.scalanative.unsafe.alloc[git_diff_file](1)
    def apply(
        id: git_oid,
        path: CString,
        size: git_object_size_t,
        flags: uint32_t,
        mode: uint16_t,
        id_abbrev: uint16_t
    )(using Zone): Ptr[git_diff_file] =
      val ____ptr = apply()
      (!____ptr).id = id
      (!____ptr).path = path
      (!____ptr).size = size
      (!____ptr).flags = flags
      (!____ptr).mode = mode
      (!____ptr).id_abbrev = id_abbrev
      ____ptr
    extension (struct: git_diff_file)
      def id: git_oid = struct._1
      def id_=(value: git_oid): Unit = !struct.at1 = value
      def path: CString = struct._2
      def path_=(value: CString): Unit = !struct.at2 = value
      def size: git_object_size_t = struct._3
      def size_=(value: git_object_size_t): Unit = !struct.at3 = value
      def flags: uint32_t = struct._4
      def flags_=(value: uint32_t): Unit = !struct.at4 = value
      def mode: uint16_t = struct._5
      def mode_=(value: uint16_t): Unit = !struct.at5 = value
      def id_abbrev: uint16_t = struct._6
      def id_abbrev_=(value: uint16_t): Unit = !struct.at6 = value

  opaque type git_diff_find_options = CStruct8[
    CUnsignedInt,
    uint32_t,
    uint16_t,
    uint16_t,
    uint16_t,
    uint16_t,
    size_t,
    Ptr[git_diff_similarity_metric]
  ]
  object git_diff_find_options:
    given _tag: Tag[git_diff_find_options] = Tag.materializeCStruct8Tag[
      CUnsignedInt,
      uint32_t,
      uint16_t,
      uint16_t,
      uint16_t,
      uint16_t,
      size_t,
      Ptr[git_diff_similarity_metric]
    ]
    def apply()(using Zone): Ptr[git_diff_find_options] =
      scala.scalanative.unsafe.alloc[git_diff_find_options](1)
    def apply(
        version: CUnsignedInt,
        flags: uint32_t,
        rename_threshold: uint16_t,
        rename_from_rewrite_threshold: uint16_t,
        copy_threshold: uint16_t,
        break_rewrite_threshold: uint16_t,
        rename_limit: size_t,
        metric: Ptr[git_diff_similarity_metric]
    )(using Zone): Ptr[git_diff_find_options] =
      val ____ptr = apply()
      (!____ptr).version = version
      (!____ptr).flags = flags
      (!____ptr).rename_threshold = rename_threshold
      (!____ptr).rename_from_rewrite_threshold = rename_from_rewrite_threshold
      (!____ptr).copy_threshold = copy_threshold
      (!____ptr).break_rewrite_threshold = break_rewrite_threshold
      (!____ptr).rename_limit = rename_limit
      (!____ptr).metric = metric
      ____ptr
    extension (struct: git_diff_find_options)
      def version: CUnsignedInt = struct._1
      def version_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def flags: uint32_t = struct._2
      def flags_=(value: uint32_t): Unit = !struct.at2 = value
      def rename_threshold: uint16_t = struct._3
      def rename_threshold_=(value: uint16_t): Unit = !struct.at3 = value
      def rename_from_rewrite_threshold: uint16_t = struct._4
      def rename_from_rewrite_threshold_=(value: uint16_t): Unit = !struct.at4 =
        value
      def copy_threshold: uint16_t = struct._5
      def copy_threshold_=(value: uint16_t): Unit = !struct.at5 = value
      def break_rewrite_threshold: uint16_t = struct._6
      def break_rewrite_threshold_=(value: uint16_t): Unit = !struct.at6 = value
      def rename_limit: size_t = struct._7
      def rename_limit_=(value: size_t): Unit = !struct.at7 = value
      def metric: Ptr[git_diff_similarity_metric] = struct._8
      def metric_=(value: Ptr[git_diff_similarity_metric]): Unit = !struct.at8 =
        value

  opaque type git_diff_format_email_options =
    CStruct8[CUnsignedInt, uint32_t, size_t, size_t, Ptr[
      git_oid
    ], CString, CString, Ptr[git_signature]]
  object git_diff_format_email_options:
    given _tag: Tag[git_diff_format_email_options] =
      Tag.materializeCStruct8Tag[CUnsignedInt, uint32_t, size_t, size_t, Ptr[
        git_oid
      ], CString, CString, Ptr[git_signature]]
    def apply()(using Zone): Ptr[git_diff_format_email_options] =
      scala.scalanative.unsafe.alloc[git_diff_format_email_options](1)
    def apply(
        version: CUnsignedInt,
        flags: uint32_t,
        patch_no: size_t,
        total_patches: size_t,
        id: Ptr[git_oid],
        summary: CString,
        body: CString,
        author: Ptr[git_signature]
    )(using Zone): Ptr[git_diff_format_email_options] =
      val ____ptr = apply()
      (!____ptr).version = version
      (!____ptr).flags = flags
      (!____ptr).patch_no = patch_no
      (!____ptr).total_patches = total_patches
      (!____ptr).id = id
      (!____ptr).summary = summary
      (!____ptr).body = body
      (!____ptr).author = author
      ____ptr
    extension (struct: git_diff_format_email_options)
      def version: CUnsignedInt = struct._1
      def version_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def flags: uint32_t = struct._2
      def flags_=(value: uint32_t): Unit = !struct.at2 = value
      def patch_no: size_t = struct._3
      def patch_no_=(value: size_t): Unit = !struct.at3 = value
      def total_patches: size_t = struct._4
      def total_patches_=(value: size_t): Unit = !struct.at4 = value
      def id: Ptr[git_oid] = struct._5
      def id_=(value: Ptr[git_oid]): Unit = !struct.at5 = value
      def summary: CString = struct._6
      def summary_=(value: CString): Unit = !struct.at6 = value
      def body: CString = struct._7
      def body_=(value: CString): Unit = !struct.at7 = value
      def author: Ptr[git_signature] = struct._8
      def author_=(value: Ptr[git_signature]): Unit = !struct.at8 = value

  opaque type git_diff_hunk = CStruct6[
    CInt,
    CInt,
    CInt,
    CInt,
    size_t,
    CArray[CChar, Nat.Digit3[Nat._1, Nat._2, Nat._8]]
  ]
  object git_diff_hunk:
    given _tag: Tag[git_diff_hunk] =
      Tag.materializeCStruct6Tag[CInt, CInt, CInt, CInt, size_t, CArray[
        CChar,
        Nat.Digit3[Nat._1, Nat._2, Nat._8]
      ]]
    def apply()(using Zone): Ptr[git_diff_hunk] =
      scala.scalanative.unsafe.alloc[git_diff_hunk](1)
    def apply(
        old_start: CInt,
        old_lines: CInt,
        new_start: CInt,
        new_lines: CInt,
        header_len: size_t,
        header: CArray[CChar, Nat.Digit3[Nat._1, Nat._2, Nat._8]]
    )(using Zone): Ptr[git_diff_hunk] =
      val ____ptr = apply()
      (!____ptr).old_start = old_start
      (!____ptr).old_lines = old_lines
      (!____ptr).new_start = new_start
      (!____ptr).new_lines = new_lines
      (!____ptr).header_len = header_len
      (!____ptr).header = header
      ____ptr
    extension (struct: git_diff_hunk)
      def old_start: CInt = struct._1
      def old_start_=(value: CInt): Unit = !struct.at1 = value
      def old_lines: CInt = struct._2
      def old_lines_=(value: CInt): Unit = !struct.at2 = value
      def new_start: CInt = struct._3
      def new_start_=(value: CInt): Unit = !struct.at3 = value
      def new_lines: CInt = struct._4
      def new_lines_=(value: CInt): Unit = !struct.at4 = value
      def header_len: size_t = struct._5
      def header_len_=(value: size_t): Unit = !struct.at5 = value
      def header: CArray[CChar, Nat.Digit3[Nat._1, Nat._2, Nat._8]] = struct._6
      def header_=(
          value: CArray[CChar, Nat.Digit3[Nat._1, Nat._2, Nat._8]]
      ): Unit = !struct.at6 = value

  opaque type git_diff_line =
    CStruct7[CChar, CInt, CInt, CInt, size_t, git_off_t, CString]
  object git_diff_line:
    given _tag: Tag[git_diff_line] = Tag.materializeCStruct7Tag[
      CChar,
      CInt,
      CInt,
      CInt,
      size_t,
      git_off_t,
      CString
    ]
    def apply()(using Zone): Ptr[git_diff_line] =
      scala.scalanative.unsafe.alloc[git_diff_line](1)
    def apply(
        origin: CChar,
        old_lineno: CInt,
        new_lineno: CInt,
        num_lines: CInt,
        content_len: size_t,
        content_offset: git_off_t,
        content: CString
    )(using Zone): Ptr[git_diff_line] =
      val ____ptr = apply()
      (!____ptr).origin = origin
      (!____ptr).old_lineno = old_lineno
      (!____ptr).new_lineno = new_lineno
      (!____ptr).num_lines = num_lines
      (!____ptr).content_len = content_len
      (!____ptr).content_offset = content_offset
      (!____ptr).content = content
      ____ptr
    extension (struct: git_diff_line)
      def origin: CChar = struct._1
      def origin_=(value: CChar): Unit = !struct.at1 = value
      def old_lineno: CInt = struct._2
      def old_lineno_=(value: CInt): Unit = !struct.at2 = value
      def new_lineno: CInt = struct._3
      def new_lineno_=(value: CInt): Unit = !struct.at3 = value
      def num_lines: CInt = struct._4
      def num_lines_=(value: CInt): Unit = !struct.at4 = value
      def content_len: size_t = struct._5
      def content_len_=(value: size_t): Unit = !struct.at5 = value
      def content_offset: git_off_t = struct._6
      def content_offset_=(value: git_off_t): Unit = !struct.at6 = value
      def content: CString = struct._7
      def content_=(value: CString): Unit = !struct.at7 = value

  opaque type git_diff_options = CStruct13[
    CUnsignedInt,
    uint32_t,
    git_submodule_ignore_t,
    git_strarray,
    git_diff_notify_cb,
    git_diff_progress_cb,
    Ptr[Byte],
    uint32_t,
    uint32_t,
    uint16_t,
    git_off_t,
    CString,
    CString
  ]
  object git_diff_options:
    given _tag: Tag[git_diff_options] = Tag.materializeCStruct13Tag[
      CUnsignedInt,
      uint32_t,
      git_submodule_ignore_t,
      git_strarray,
      git_diff_notify_cb,
      git_diff_progress_cb,
      Ptr[Byte],
      uint32_t,
      uint32_t,
      uint16_t,
      git_off_t,
      CString,
      CString
    ]
    def apply()(using Zone): Ptr[git_diff_options] =
      scala.scalanative.unsafe.alloc[git_diff_options](1)
    def apply(
        version: CUnsignedInt,
        flags: uint32_t,
        ignore_submodules: git_submodule_ignore_t,
        pathspec: git_strarray,
        notify_cb: git_diff_notify_cb,
        progress_cb: git_diff_progress_cb,
        payload: Ptr[Byte],
        context_lines: uint32_t,
        interhunk_lines: uint32_t,
        id_abbrev: uint16_t,
        max_size: git_off_t,
        old_prefix: CString,
        new_prefix: CString
    )(using Zone): Ptr[git_diff_options] =
      val ____ptr = apply()
      (!____ptr).version = version
      (!____ptr).flags = flags
      (!____ptr).ignore_submodules = ignore_submodules
      (!____ptr).pathspec = pathspec
      (!____ptr).notify_cb = notify_cb
      (!____ptr).progress_cb = progress_cb
      (!____ptr).payload = payload
      (!____ptr).context_lines = context_lines
      (!____ptr).interhunk_lines = interhunk_lines
      (!____ptr).id_abbrev = id_abbrev
      (!____ptr).max_size = max_size
      (!____ptr).old_prefix = old_prefix
      (!____ptr).new_prefix = new_prefix
      ____ptr
    extension (struct: git_diff_options)
      def version: CUnsignedInt = struct._1
      def version_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def flags: uint32_t = struct._2
      def flags_=(value: uint32_t): Unit = !struct.at2 = value
      def ignore_submodules: git_submodule_ignore_t = struct._3
      def ignore_submodules_=(value: git_submodule_ignore_t): Unit =
        !struct.at3 = value
      def pathspec: git_strarray = struct._4
      def pathspec_=(value: git_strarray): Unit = !struct.at4 = value
      def notify_cb: git_diff_notify_cb = struct._5
      def notify_cb_=(value: git_diff_notify_cb): Unit = !struct.at5 = value
      def progress_cb: git_diff_progress_cb = struct._6
      def progress_cb_=(value: git_diff_progress_cb): Unit = !struct.at6 = value
      def payload: Ptr[Byte] = struct._7
      def payload_=(value: Ptr[Byte]): Unit = !struct.at7 = value
      def context_lines: uint32_t = struct._8
      def context_lines_=(value: uint32_t): Unit = !struct.at8 = value
      def interhunk_lines: uint32_t = struct._9
      def interhunk_lines_=(value: uint32_t): Unit = !struct.at9 = value
      def id_abbrev: uint16_t = struct._10
      def id_abbrev_=(value: uint16_t): Unit = !struct.at10 = value
      def max_size: git_off_t = struct._11
      def max_size_=(value: git_off_t): Unit = !struct.at11 = value
      def old_prefix: CString = struct._12
      def old_prefix_=(value: CString): Unit = !struct.at12 = value
      def new_prefix: CString = struct._13
      def new_prefix_=(value: CString): Unit = !struct.at13 = value

  opaque type git_diff_patchid_options = CStruct1[CUnsignedInt]
  object git_diff_patchid_options:
    given _tag: Tag[git_diff_patchid_options] =
      Tag.materializeCStruct1Tag[CUnsignedInt]
    def apply()(using Zone): Ptr[git_diff_patchid_options] =
      scala.scalanative.unsafe.alloc[git_diff_patchid_options](1)
    def apply(version: CUnsignedInt)(using
        Zone
    ): Ptr[git_diff_patchid_options] =
      val ____ptr = apply()
      (!____ptr).version = version
      ____ptr
    extension (struct: git_diff_patchid_options)
      def version: CUnsignedInt = struct._1
      def version_=(value: CUnsignedInt): Unit = !struct.at1 = value

  opaque type git_diff_similarity_metric = CStruct5[
    CFuncPtr4[Ptr[Ptr[Byte]], Ptr[git_diff_file], CString, Ptr[Byte], CInt],
    CFuncPtr5[Ptr[Ptr[Byte]], Ptr[git_diff_file], CString, size_t, Ptr[
      Byte
    ], CInt],
    CFuncPtr2[Ptr[Byte], Ptr[Byte], Unit],
    CFuncPtr4[Ptr[CInt], Ptr[Byte], Ptr[Byte], Ptr[Byte], CInt],
    Ptr[Byte]
  ]
  object git_diff_similarity_metric:
    given _tag: Tag[git_diff_similarity_metric] = Tag.materializeCStruct5Tag[
      CFuncPtr4[Ptr[Ptr[Byte]], Ptr[git_diff_file], CString, Ptr[Byte], CInt],
      CFuncPtr5[Ptr[Ptr[Byte]], Ptr[git_diff_file], CString, size_t, Ptr[
        Byte
      ], CInt],
      CFuncPtr2[Ptr[Byte], Ptr[Byte], Unit],
      CFuncPtr4[Ptr[CInt], Ptr[Byte], Ptr[Byte], Ptr[Byte], CInt],
      Ptr[Byte]
    ]
    def apply()(using Zone): Ptr[git_diff_similarity_metric] =
      scala.scalanative.unsafe.alloc[git_diff_similarity_metric](1)
    def apply(
        file_signature: CFuncPtr4[Ptr[Ptr[Byte]], Ptr[
          git_diff_file
        ], CString, Ptr[Byte], CInt],
        buffer_signature: CFuncPtr5[Ptr[Ptr[Byte]], Ptr[
          git_diff_file
        ], CString, size_t, Ptr[Byte], CInt],
        free_signature: CFuncPtr2[Ptr[Byte], Ptr[Byte], Unit],
        similarity: CFuncPtr4[Ptr[CInt], Ptr[Byte], Ptr[Byte], Ptr[Byte], CInt],
        payload: Ptr[Byte]
    )(using Zone): Ptr[git_diff_similarity_metric] =
      val ____ptr = apply()
      (!____ptr).file_signature = file_signature
      (!____ptr).buffer_signature = buffer_signature
      (!____ptr).free_signature = free_signature
      (!____ptr).similarity = similarity
      (!____ptr).payload = payload
      ____ptr
    extension (struct: git_diff_similarity_metric)
      def file_signature: CFuncPtr4[Ptr[Ptr[Byte]], Ptr[
        git_diff_file
      ], CString, Ptr[Byte], CInt] = struct._1
      def file_signature_=(
          value: CFuncPtr4[Ptr[Ptr[Byte]], Ptr[git_diff_file], CString, Ptr[
            Byte
          ], CInt]
      ): Unit = !struct.at1 = value
      def buffer_signature: CFuncPtr5[Ptr[Ptr[Byte]], Ptr[
        git_diff_file
      ], CString, size_t, Ptr[Byte], CInt] = struct._2
      def buffer_signature_=(
          value: CFuncPtr5[Ptr[Ptr[Byte]], Ptr[
            git_diff_file
          ], CString, size_t, Ptr[Byte], CInt]
      ): Unit = !struct.at2 = value
      def free_signature: CFuncPtr2[Ptr[Byte], Ptr[Byte], Unit] = struct._3
      def free_signature_=(value: CFuncPtr2[Ptr[Byte], Ptr[Byte], Unit]): Unit =
        !struct.at3 = value
      def similarity
          : CFuncPtr4[Ptr[CInt], Ptr[Byte], Ptr[Byte], Ptr[Byte], CInt] =
        struct._4
      def similarity_=(
          value: CFuncPtr4[Ptr[CInt], Ptr[Byte], Ptr[Byte], Ptr[Byte], CInt]
      ): Unit = !struct.at4 = value
      def payload: Ptr[Byte] = struct._5
      def payload_=(value: Ptr[Byte]): Unit = !struct.at5 = value

  opaque type git_diff_stats = CStruct0
  object git_diff_stats:
    given _tag: Tag[git_diff_stats] = Tag.materializeCStruct0Tag

  opaque type git_email_create_options = CStruct7[
    CUnsignedInt,
    uint32_t,
    git_diff_options,
    git_diff_find_options,
    CString,
    size_t,
    size_t
  ]
  object git_email_create_options:
    given _tag: Tag[git_email_create_options] = Tag.materializeCStruct7Tag[
      CUnsignedInt,
      uint32_t,
      git_diff_options,
      git_diff_find_options,
      CString,
      size_t,
      size_t
    ]
    def apply()(using Zone): Ptr[git_email_create_options] =
      scala.scalanative.unsafe.alloc[git_email_create_options](1)
    def apply(
        version: CUnsignedInt,
        flags: uint32_t,
        diff_opts: git_diff_options,
        diff_find_opts: git_diff_find_options,
        subject_prefix: CString,
        start_number: size_t,
        reroll_number: size_t
    )(using Zone): Ptr[git_email_create_options] =
      val ____ptr = apply()
      (!____ptr).version = version
      (!____ptr).flags = flags
      (!____ptr).diff_opts = diff_opts
      (!____ptr).diff_find_opts = diff_find_opts
      (!____ptr).subject_prefix = subject_prefix
      (!____ptr).start_number = start_number
      (!____ptr).reroll_number = reroll_number
      ____ptr
    extension (struct: git_email_create_options)
      def version: CUnsignedInt = struct._1
      def version_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def flags: uint32_t = struct._2
      def flags_=(value: uint32_t): Unit = !struct.at2 = value
      def diff_opts: git_diff_options = struct._3
      def diff_opts_=(value: git_diff_options): Unit = !struct.at3 = value
      def diff_find_opts: git_diff_find_options = struct._4
      def diff_find_opts_=(value: git_diff_find_options): Unit = !struct.at4 =
        value
      def subject_prefix: CString = struct._5
      def subject_prefix_=(value: CString): Unit = !struct.at5 = value
      def start_number: size_t = struct._6
      def start_number_=(value: size_t): Unit = !struct.at6 = value
      def reroll_number: size_t = struct._7
      def reroll_number_=(value: size_t): Unit = !struct.at7 = value

  opaque type git_error = CStruct2[CString, CInt]
  object git_error:
    given _tag: Tag[git_error] = Tag.materializeCStruct2Tag[CString, CInt]
    def apply()(using Zone): Ptr[git_error] =
      scala.scalanative.unsafe.alloc[git_error](1)
    def apply(message: CString, klass: CInt)(using Zone): Ptr[git_error] =
      val ____ptr = apply()
      (!____ptr).message = message
      (!____ptr).klass = klass
      ____ptr
    extension (struct: git_error)
      def message: CString = struct._1
      def message_=(value: CString): Unit = !struct.at1 = value
      def klass: CInt = struct._2
      def klass_=(value: CInt): Unit = !struct.at2 = value

  opaque type git_fetch_options = CStruct8[
    CInt,
    git_remote_callbacks,
    git_fetch_prune_t,
    CInt,
    git_remote_autotag_option_t,
    git_proxy_options,
    git_remote_redirect_t,
    git_strarray
  ]
  object git_fetch_options:
    given _tag: Tag[git_fetch_options] = Tag.materializeCStruct8Tag[
      CInt,
      git_remote_callbacks,
      git_fetch_prune_t,
      CInt,
      git_remote_autotag_option_t,
      git_proxy_options,
      git_remote_redirect_t,
      git_strarray
    ]
    def apply()(using Zone): Ptr[git_fetch_options] =
      scala.scalanative.unsafe.alloc[git_fetch_options](1)
    def apply(
        version: CInt,
        callbacks: git_remote_callbacks,
        prune: git_fetch_prune_t,
        update_fetchhead: CInt,
        download_tags: git_remote_autotag_option_t,
        proxy_opts: git_proxy_options,
        follow_redirects: git_remote_redirect_t,
        custom_headers: git_strarray
    )(using Zone): Ptr[git_fetch_options] =
      val ____ptr = apply()
      (!____ptr).version = version
      (!____ptr).callbacks = callbacks
      (!____ptr).prune = prune
      (!____ptr).update_fetchhead = update_fetchhead
      (!____ptr).download_tags = download_tags
      (!____ptr).proxy_opts = proxy_opts
      (!____ptr).follow_redirects = follow_redirects
      (!____ptr).custom_headers = custom_headers
      ____ptr
    extension (struct: git_fetch_options)
      def version: CInt = struct._1
      def version_=(value: CInt): Unit = !struct.at1 = value
      def callbacks: git_remote_callbacks = struct._2
      def callbacks_=(value: git_remote_callbacks): Unit = !struct.at2 = value
      def prune: git_fetch_prune_t = struct._3
      def prune_=(value: git_fetch_prune_t): Unit = !struct.at3 = value
      def update_fetchhead: CInt = struct._4
      def update_fetchhead_=(value: CInt): Unit = !struct.at4 = value
      def download_tags: git_remote_autotag_option_t = struct._5
      def download_tags_=(value: git_remote_autotag_option_t): Unit =
        !struct.at5 = value
      def proxy_opts: git_proxy_options = struct._6
      def proxy_opts_=(value: git_proxy_options): Unit = !struct.at6 = value
      def follow_redirects: git_remote_redirect_t = struct._7
      def follow_redirects_=(value: git_remote_redirect_t): Unit = !struct.at7 =
        value
      def custom_headers: git_strarray = struct._8
      def custom_headers_=(value: git_strarray): Unit = !struct.at8 = value

  opaque type git_filter = CStruct0
  object git_filter:
    given _tag: Tag[git_filter] = Tag.materializeCStruct0Tag

  opaque type git_filter_list = CStruct0
  object git_filter_list:
    given _tag: Tag[git_filter_list] = Tag.materializeCStruct0Tag

  opaque type git_filter_options =
    CStruct4[CUnsignedInt, uint32_t, Ptr[git_oid], git_oid]
  object git_filter_options:
    given _tag: Tag[git_filter_options] =
      Tag.materializeCStruct4Tag[CUnsignedInt, uint32_t, Ptr[git_oid], git_oid]
    def apply()(using Zone): Ptr[git_filter_options] =
      scala.scalanative.unsafe.alloc[git_filter_options](1)
    def apply(
        version: CUnsignedInt,
        flags: uint32_t,
        commit_id: Ptr[git_oid],
        attr_commit_id: git_oid
    )(using Zone): Ptr[git_filter_options] =
      val ____ptr = apply()
      (!____ptr).version = version
      (!____ptr).flags = flags
      (!____ptr).commit_id = commit_id
      (!____ptr).attr_commit_id = attr_commit_id
      ____ptr
    extension (struct: git_filter_options)
      def version: CUnsignedInt = struct._1
      def version_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def flags: uint32_t = struct._2
      def flags_=(value: uint32_t): Unit = !struct.at2 = value
      def commit_id: Ptr[git_oid] = struct._3
      def commit_id_=(value: Ptr[git_oid]): Unit = !struct.at3 = value
      def attr_commit_id: git_oid = struct._4
      def attr_commit_id_=(value: git_oid): Unit = !struct.at4 = value

  opaque type git_index = CStruct0
  object git_index:
    given _tag: Tag[git_index] = Tag.materializeCStruct0Tag

  opaque type git_index_conflict_iterator = CStruct0
  object git_index_conflict_iterator:
    given _tag: Tag[git_index_conflict_iterator] = Tag.materializeCStruct0Tag

  opaque type git_index_entry = CStruct12[
    git_index_time,
    git_index_time,
    uint32_t,
    uint32_t,
    uint32_t,
    uint32_t,
    uint32_t,
    uint32_t,
    git_oid,
    uint16_t,
    uint16_t,
    CString
  ]
  object git_index_entry:
    given _tag: Tag[git_index_entry] = Tag.materializeCStruct12Tag[
      git_index_time,
      git_index_time,
      uint32_t,
      uint32_t,
      uint32_t,
      uint32_t,
      uint32_t,
      uint32_t,
      git_oid,
      uint16_t,
      uint16_t,
      CString
    ]
    def apply()(using Zone): Ptr[git_index_entry] =
      scala.scalanative.unsafe.alloc[git_index_entry](1)
    def apply(
        ctime: git_index_time,
        mtime: git_index_time,
        dev: uint32_t,
        ino: uint32_t,
        mode: uint32_t,
        uid: uint32_t,
        gid: uint32_t,
        file_size: uint32_t,
        id: git_oid,
        flags: uint16_t,
        flags_extended: uint16_t,
        path: CString
    )(using Zone): Ptr[git_index_entry] =
      val ____ptr = apply()
      (!____ptr).ctime = ctime
      (!____ptr).mtime = mtime
      (!____ptr).dev = dev
      (!____ptr).ino = ino
      (!____ptr).mode = mode
      (!____ptr).uid = uid
      (!____ptr).gid = gid
      (!____ptr).file_size = file_size
      (!____ptr).id = id
      (!____ptr).flags = flags
      (!____ptr).flags_extended = flags_extended
      (!____ptr).path = path
      ____ptr
    extension (struct: git_index_entry)
      def ctime: git_index_time = struct._1
      def ctime_=(value: git_index_time): Unit = !struct.at1 = value
      def mtime: git_index_time = struct._2
      def mtime_=(value: git_index_time): Unit = !struct.at2 = value
      def dev: uint32_t = struct._3
      def dev_=(value: uint32_t): Unit = !struct.at3 = value
      def ino: uint32_t = struct._4
      def ino_=(value: uint32_t): Unit = !struct.at4 = value
      def mode: uint32_t = struct._5
      def mode_=(value: uint32_t): Unit = !struct.at5 = value
      def uid: uint32_t = struct._6
      def uid_=(value: uint32_t): Unit = !struct.at6 = value
      def gid: uint32_t = struct._7
      def gid_=(value: uint32_t): Unit = !struct.at7 = value
      def file_size: uint32_t = struct._8
      def file_size_=(value: uint32_t): Unit = !struct.at8 = value
      def id: git_oid = struct._9
      def id_=(value: git_oid): Unit = !struct.at9 = value
      def flags: uint16_t = struct._10
      def flags_=(value: uint16_t): Unit = !struct.at10 = value
      def flags_extended: uint16_t = struct._11
      def flags_extended_=(value: uint16_t): Unit = !struct.at11 = value
      def path: CString = struct._12
      def path_=(value: CString): Unit = !struct.at12 = value

  opaque type git_index_iterator = CStruct0
  object git_index_iterator:
    given _tag: Tag[git_index_iterator] = Tag.materializeCStruct0Tag

  opaque type git_index_time = CStruct2[int32_t, uint32_t]
  object git_index_time:
    given _tag: Tag[git_index_time] =
      Tag.materializeCStruct2Tag[int32_t, uint32_t]
    def apply()(using Zone): Ptr[git_index_time] =
      scala.scalanative.unsafe.alloc[git_index_time](1)
    def apply(seconds: int32_t, nanoseconds: uint32_t)(using
        Zone
    ): Ptr[git_index_time] =
      val ____ptr = apply()
      (!____ptr).seconds = seconds
      (!____ptr).nanoseconds = nanoseconds
      ____ptr
    extension (struct: git_index_time)
      def seconds: int32_t = struct._1
      def seconds_=(value: int32_t): Unit = !struct.at1 = value
      def nanoseconds: uint32_t = struct._2
      def nanoseconds_=(value: uint32_t): Unit = !struct.at2 = value

  opaque type git_indexer = CStruct0
  object git_indexer:
    given _tag: Tag[git_indexer] = Tag.materializeCStruct0Tag

  opaque type git_indexer_options =
    CStruct4[CUnsignedInt, git_indexer_progress_cb, Ptr[Byte], CUnsignedChar]
  object git_indexer_options:
    given _tag: Tag[git_indexer_options] =
      Tag.materializeCStruct4Tag[CUnsignedInt, git_indexer_progress_cb, Ptr[
        Byte
      ], CUnsignedChar]
    def apply()(using Zone): Ptr[git_indexer_options] =
      scala.scalanative.unsafe.alloc[git_indexer_options](1)
    def apply(
        version: CUnsignedInt,
        progress_cb: git_indexer_progress_cb,
        progress_cb_payload: Ptr[Byte],
        verify: CUnsignedChar
    )(using Zone): Ptr[git_indexer_options] =
      val ____ptr = apply()
      (!____ptr).version = version
      (!____ptr).progress_cb = progress_cb
      (!____ptr).progress_cb_payload = progress_cb_payload
      (!____ptr).verify = verify
      ____ptr
    extension (struct: git_indexer_options)
      def version: CUnsignedInt = struct._1
      def version_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def progress_cb: git_indexer_progress_cb = struct._2
      def progress_cb_=(value: git_indexer_progress_cb): Unit = !struct.at2 =
        value
      def progress_cb_payload: Ptr[Byte] = struct._3
      def progress_cb_payload_=(value: Ptr[Byte]): Unit = !struct.at3 = value
      def verify: CUnsignedChar = struct._4
      def verify_=(value: CUnsignedChar): Unit = !struct.at4 = value

  opaque type git_indexer_progress = CStruct7[
    CUnsignedInt,
    CUnsignedInt,
    CUnsignedInt,
    CUnsignedInt,
    CUnsignedInt,
    CUnsignedInt,
    size_t
  ]
  object git_indexer_progress:
    given _tag: Tag[git_indexer_progress] = Tag.materializeCStruct7Tag[
      CUnsignedInt,
      CUnsignedInt,
      CUnsignedInt,
      CUnsignedInt,
      CUnsignedInt,
      CUnsignedInt,
      size_t
    ]
    def apply()(using Zone): Ptr[git_indexer_progress] =
      scala.scalanative.unsafe.alloc[git_indexer_progress](1)
    def apply(
        total_objects: CUnsignedInt,
        indexed_objects: CUnsignedInt,
        received_objects: CUnsignedInt,
        local_objects: CUnsignedInt,
        total_deltas: CUnsignedInt,
        indexed_deltas: CUnsignedInt,
        received_bytes: size_t
    )(using Zone): Ptr[git_indexer_progress] =
      val ____ptr = apply()
      (!____ptr).total_objects = total_objects
      (!____ptr).indexed_objects = indexed_objects
      (!____ptr).received_objects = received_objects
      (!____ptr).local_objects = local_objects
      (!____ptr).total_deltas = total_deltas
      (!____ptr).indexed_deltas = indexed_deltas
      (!____ptr).received_bytes = received_bytes
      ____ptr
    extension (struct: git_indexer_progress)
      def total_objects: CUnsignedInt = struct._1
      def total_objects_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def indexed_objects: CUnsignedInt = struct._2
      def indexed_objects_=(value: CUnsignedInt): Unit = !struct.at2 = value
      def received_objects: CUnsignedInt = struct._3
      def received_objects_=(value: CUnsignedInt): Unit = !struct.at3 = value
      def local_objects: CUnsignedInt = struct._4
      def local_objects_=(value: CUnsignedInt): Unit = !struct.at4 = value
      def total_deltas: CUnsignedInt = struct._5
      def total_deltas_=(value: CUnsignedInt): Unit = !struct.at5 = value
      def indexed_deltas: CUnsignedInt = struct._6
      def indexed_deltas_=(value: CUnsignedInt): Unit = !struct.at6 = value
      def received_bytes: size_t = struct._7
      def received_bytes_=(value: size_t): Unit = !struct.at7 = value

  opaque type git_iterator = CStruct0
  object git_iterator:
    given _tag: Tag[git_iterator] = Tag.materializeCStruct0Tag

  opaque type git_mailmap = CStruct0
  object git_mailmap:
    given _tag: Tag[git_mailmap] = Tag.materializeCStruct0Tag

  opaque type git_merge_file_input =
    CStruct5[CUnsignedInt, CString, size_t, CString, CUnsignedInt]
  object git_merge_file_input:
    given _tag: Tag[git_merge_file_input] = Tag.materializeCStruct5Tag[
      CUnsignedInt,
      CString,
      size_t,
      CString,
      CUnsignedInt
    ]
    def apply()(using Zone): Ptr[git_merge_file_input] =
      scala.scalanative.unsafe.alloc[git_merge_file_input](1)
    def apply(
        version: CUnsignedInt,
        ptr: CString,
        size: size_t,
        path: CString,
        mode: CUnsignedInt
    )(using Zone): Ptr[git_merge_file_input] =
      val ____ptr = apply()
      (!____ptr).version = version
      (!____ptr).ptr = ptr
      (!____ptr).size = size
      (!____ptr).path = path
      (!____ptr).mode = mode
      ____ptr
    extension (struct: git_merge_file_input)
      def version: CUnsignedInt = struct._1
      def version_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def ptr: CString = struct._2
      def ptr_=(value: CString): Unit = !struct.at2 = value
      def size: size_t = struct._3
      def size_=(value: size_t): Unit = !struct.at3 = value
      def path: CString = struct._4
      def path_=(value: CString): Unit = !struct.at4 = value
      def mode: CUnsignedInt = struct._5
      def mode_=(value: CUnsignedInt): Unit = !struct.at5 = value

  opaque type git_merge_file_options = CStruct7[
    CUnsignedInt,
    CString,
    CString,
    CString,
    git_merge_file_favor_t,
    uint32_t,
    CUnsignedShort
  ]
  object git_merge_file_options:
    given _tag: Tag[git_merge_file_options] = Tag.materializeCStruct7Tag[
      CUnsignedInt,
      CString,
      CString,
      CString,
      git_merge_file_favor_t,
      uint32_t,
      CUnsignedShort
    ]
    def apply()(using Zone): Ptr[git_merge_file_options] =
      scala.scalanative.unsafe.alloc[git_merge_file_options](1)
    def apply(
        version: CUnsignedInt,
        ancestor_label: CString,
        our_label: CString,
        their_label: CString,
        favor: git_merge_file_favor_t,
        flags: uint32_t,
        marker_size: CUnsignedShort
    )(using Zone): Ptr[git_merge_file_options] =
      val ____ptr = apply()
      (!____ptr).version = version
      (!____ptr).ancestor_label = ancestor_label
      (!____ptr).our_label = our_label
      (!____ptr).their_label = their_label
      (!____ptr).favor = favor
      (!____ptr).flags = flags
      (!____ptr).marker_size = marker_size
      ____ptr
    extension (struct: git_merge_file_options)
      def version: CUnsignedInt = struct._1
      def version_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def ancestor_label: CString = struct._2
      def ancestor_label_=(value: CString): Unit = !struct.at2 = value
      def our_label: CString = struct._3
      def our_label_=(value: CString): Unit = !struct.at3 = value
      def their_label: CString = struct._4
      def their_label_=(value: CString): Unit = !struct.at4 = value
      def favor: git_merge_file_favor_t = struct._5
      def favor_=(value: git_merge_file_favor_t): Unit = !struct.at5 = value
      def flags: uint32_t = struct._6
      def flags_=(value: uint32_t): Unit = !struct.at6 = value
      def marker_size: CUnsignedShort = struct._7
      def marker_size_=(value: CUnsignedShort): Unit = !struct.at7 = value

  opaque type git_merge_file_result =
    CStruct5[CUnsignedInt, CString, CUnsignedInt, CString, size_t]
  object git_merge_file_result:
    given _tag: Tag[git_merge_file_result] = Tag.materializeCStruct5Tag[
      CUnsignedInt,
      CString,
      CUnsignedInt,
      CString,
      size_t
    ]
    def apply()(using Zone): Ptr[git_merge_file_result] =
      scala.scalanative.unsafe.alloc[git_merge_file_result](1)
    def apply(
        automergeable: CUnsignedInt,
        path: CString,
        mode: CUnsignedInt,
        ptr: CString,
        len: size_t
    )(using Zone): Ptr[git_merge_file_result] =
      val ____ptr = apply()
      (!____ptr).automergeable = automergeable
      (!____ptr).path = path
      (!____ptr).mode = mode
      (!____ptr).ptr = ptr
      (!____ptr).len = len
      ____ptr
    extension (struct: git_merge_file_result)
      def automergeable: CUnsignedInt = struct._1
      def automergeable_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def path: CString = struct._2
      def path_=(value: CString): Unit = !struct.at2 = value
      def mode: CUnsignedInt = struct._3
      def mode_=(value: CUnsignedInt): Unit = !struct.at3 = value
      def ptr: CString = struct._4
      def ptr_=(value: CString): Unit = !struct.at4 = value
      def len: size_t = struct._5
      def len_=(value: size_t): Unit = !struct.at5 = value

  opaque type git_merge_options =
    CStruct9[CUnsignedInt, uint32_t, CUnsignedInt, CUnsignedInt, Ptr[
      git_diff_similarity_metric
    ], CUnsignedInt, CString, git_merge_file_favor_t, uint32_t]
  object git_merge_options:
    given _tag: Tag[git_merge_options] = Tag.materializeCStruct9Tag[
      CUnsignedInt,
      uint32_t,
      CUnsignedInt,
      CUnsignedInt,
      Ptr[git_diff_similarity_metric],
      CUnsignedInt,
      CString,
      git_merge_file_favor_t,
      uint32_t
    ]
    def apply()(using Zone): Ptr[git_merge_options] =
      scala.scalanative.unsafe.alloc[git_merge_options](1)
    def apply(
        version: CUnsignedInt,
        flags: uint32_t,
        rename_threshold: CUnsignedInt,
        target_limit: CUnsignedInt,
        metric: Ptr[git_diff_similarity_metric],
        recursion_limit: CUnsignedInt,
        default_driver: CString,
        file_favor: git_merge_file_favor_t,
        file_flags: uint32_t
    )(using Zone): Ptr[git_merge_options] =
      val ____ptr = apply()
      (!____ptr).version = version
      (!____ptr).flags = flags
      (!____ptr).rename_threshold = rename_threshold
      (!____ptr).target_limit = target_limit
      (!____ptr).metric = metric
      (!____ptr).recursion_limit = recursion_limit
      (!____ptr).default_driver = default_driver
      (!____ptr).file_favor = file_favor
      (!____ptr).file_flags = file_flags
      ____ptr
    extension (struct: git_merge_options)
      def version: CUnsignedInt = struct._1
      def version_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def flags: uint32_t = struct._2
      def flags_=(value: uint32_t): Unit = !struct.at2 = value
      def rename_threshold: CUnsignedInt = struct._3
      def rename_threshold_=(value: CUnsignedInt): Unit = !struct.at3 = value
      def target_limit: CUnsignedInt = struct._4
      def target_limit_=(value: CUnsignedInt): Unit = !struct.at4 = value
      def metric: Ptr[git_diff_similarity_metric] = struct._5
      def metric_=(value: Ptr[git_diff_similarity_metric]): Unit = !struct.at5 =
        value
      def recursion_limit: CUnsignedInt = struct._6
      def recursion_limit_=(value: CUnsignedInt): Unit = !struct.at6 = value
      def default_driver: CString = struct._7
      def default_driver_=(value: CString): Unit = !struct.at7 = value
      def file_favor: git_merge_file_favor_t = struct._8
      def file_favor_=(value: git_merge_file_favor_t): Unit = !struct.at8 =
        value
      def file_flags: uint32_t = struct._9
      def file_flags_=(value: uint32_t): Unit = !struct.at9 = value

  opaque type git_message_trailer = CStruct2[CString, CString]
  object git_message_trailer:
    given _tag: Tag[git_message_trailer] =
      Tag.materializeCStruct2Tag[CString, CString]
    def apply()(using Zone): Ptr[git_message_trailer] =
      scala.scalanative.unsafe.alloc[git_message_trailer](1)
    def apply(key: CString, value: CString)(using
        Zone
    ): Ptr[git_message_trailer] =
      val ____ptr = apply()
      (!____ptr).key = key
      (!____ptr).value = value
      ____ptr
    extension (struct: git_message_trailer)
      def key: CString = struct._1
      def key_=(value: CString): Unit = !struct.at1 = value
      def value: CString = struct._2
      def value_=(value: CString): Unit = !struct.at2 = value

  opaque type git_message_trailer_array =
    CStruct3[Ptr[git_message_trailer], size_t, CString]
  object git_message_trailer_array:
    given _tag: Tag[git_message_trailer_array] =
      Tag.materializeCStruct3Tag[Ptr[git_message_trailer], size_t, CString]
    def apply()(using Zone): Ptr[git_message_trailer_array] =
      scala.scalanative.unsafe.alloc[git_message_trailer_array](1)
    def apply(
        trailers: Ptr[git_message_trailer],
        count: size_t,
        _trailer_block: CString
    )(using Zone): Ptr[git_message_trailer_array] =
      val ____ptr = apply()
      (!____ptr).trailers = trailers
      (!____ptr).count = count
      (!____ptr)._trailer_block = _trailer_block
      ____ptr
    extension (struct: git_message_trailer_array)
      def trailers: Ptr[git_message_trailer] = struct._1
      def trailers_=(value: Ptr[git_message_trailer]): Unit = !struct.at1 =
        value
      def count: size_t = struct._2
      def count_=(value: size_t): Unit = !struct.at2 = value
      def _trailer_block: CString = struct._3
      def _trailer_block_=(value: CString): Unit = !struct.at3 = value

  opaque type git_midx_writer = CStruct0
  object git_midx_writer:
    given _tag: Tag[git_midx_writer] = Tag.materializeCStruct0Tag

  opaque type git_note = CStruct0
  object git_note:
    given _tag: Tag[git_note] = Tag.materializeCStruct0Tag

  opaque type git_note_iterator = CStruct0
  object git_note_iterator:
    given _tag: Tag[git_note_iterator] = Tag.materializeCStruct0Tag

  opaque type git_object = CStruct0
  object git_object:
    given _tag: Tag[git_object] = Tag.materializeCStruct0Tag

  opaque type git_odb = CStruct0
  object git_odb:
    given _tag: Tag[git_odb] = Tag.materializeCStruct0Tag

  opaque type git_odb_backend = CStruct0
  object git_odb_backend:
    given _tag: Tag[git_odb_backend] = Tag.materializeCStruct0Tag

  opaque type git_odb_expand_id =
    CStruct3[git_oid, CUnsignedShort, git_object_t]
  object git_odb_expand_id:
    given _tag: Tag[git_odb_expand_id] =
      Tag.materializeCStruct3Tag[git_oid, CUnsignedShort, git_object_t]
    def apply()(using Zone): Ptr[git_odb_expand_id] =
      scala.scalanative.unsafe.alloc[git_odb_expand_id](1)
    def apply(id: git_oid, length: CUnsignedShort, `type`: git_object_t)(using
        Zone
    ): Ptr[git_odb_expand_id] =
      val ____ptr = apply()
      (!____ptr).id = id
      (!____ptr).length = length
      (!____ptr).`type` = `type`
      ____ptr
    extension (struct: git_odb_expand_id)
      def id: git_oid = struct._1
      def id_=(value: git_oid): Unit = !struct.at1 = value
      def length: CUnsignedShort = struct._2
      def length_=(value: CUnsignedShort): Unit = !struct.at2 = value
      def `type`: git_object_t = struct._3
      def type_=(value: git_object_t): Unit = !struct.at3 = value

  opaque type git_odb_object = CStruct0
  object git_odb_object:
    given _tag: Tag[git_odb_object] = Tag.materializeCStruct0Tag

  opaque type git_odb_stream = CStruct9[Ptr[git_odb_backend], CUnsignedInt, Ptr[
    Byte
  ], git_object_size_t, git_object_size_t, CFuncPtr3[
    Ptr[Byte],
    CString,
    size_t,
    CInt
  ], CFuncPtr3[Ptr[Byte], CString, size_t, CInt], CFuncPtr2[Ptr[Byte], Ptr[
    git_oid
  ], CInt], CFuncPtr1[Ptr[Byte], Unit]]
  object git_odb_stream:
    given _tag: Tag[git_odb_stream] = Tag.materializeCStruct9Tag[Ptr[
      git_odb_backend
    ], CUnsignedInt, Ptr[Byte], git_object_size_t, git_object_size_t, CFuncPtr3[
      Ptr[Byte],
      CString,
      size_t,
      CInt
    ], CFuncPtr3[Ptr[Byte], CString, size_t, CInt], CFuncPtr2[Ptr[Byte], Ptr[
      git_oid
    ], CInt], CFuncPtr1[Ptr[Byte], Unit]]
    def apply()(using Zone): Ptr[git_odb_stream] =
      scala.scalanative.unsafe.alloc[git_odb_stream](1)
    def apply(
        backend: Ptr[git_odb_backend],
        mode: CUnsignedInt,
        hash_ctx: Ptr[Byte],
        declared_size: git_object_size_t,
        received_bytes: git_object_size_t,
        read: CFuncPtr3[Ptr[git_odb_stream], CString, size_t, CInt],
        write: CFuncPtr3[Ptr[git_odb_stream], CString, size_t, CInt],
        finalize_write: CFuncPtr2[Ptr[git_odb_stream], Ptr[git_oid], CInt],
        free: CFuncPtr1[Ptr[git_odb_stream], Unit]
    )(using Zone): Ptr[git_odb_stream] =
      val ____ptr = apply()
      (!____ptr).backend = backend
      (!____ptr).mode = mode
      (!____ptr).hash_ctx = hash_ctx
      (!____ptr).declared_size = declared_size
      (!____ptr).received_bytes = received_bytes
      (!____ptr).read = read
      (!____ptr).write = write
      (!____ptr).finalize_write = finalize_write
      (!____ptr).free = free
      ____ptr
    extension (struct: git_odb_stream)
      def backend: Ptr[git_odb_backend] = struct._1
      def backend_=(value: Ptr[git_odb_backend]): Unit = !struct.at1 = value
      def mode: CUnsignedInt = struct._2
      def mode_=(value: CUnsignedInt): Unit = !struct.at2 = value
      def hash_ctx: Ptr[Byte] = struct._3
      def hash_ctx_=(value: Ptr[Byte]): Unit = !struct.at3 = value
      def declared_size: git_object_size_t = struct._4
      def declared_size_=(value: git_object_size_t): Unit = !struct.at4 = value
      def received_bytes: git_object_size_t = struct._5
      def received_bytes_=(value: git_object_size_t): Unit = !struct.at5 = value
      def read: CFuncPtr3[Ptr[git_odb_stream], CString, size_t, CInt] =
        struct._6
          .asInstanceOf[CFuncPtr3[Ptr[git_odb_stream], CString, size_t, CInt]]
      def read_=(
          value: CFuncPtr3[Ptr[git_odb_stream], CString, size_t, CInt]
      ): Unit = !struct.at6 =
        value.asInstanceOf[CFuncPtr3[Ptr[Byte], CString, size_t, CInt]]
      def write: CFuncPtr3[Ptr[git_odb_stream], CString, size_t, CInt] =
        struct._7
          .asInstanceOf[CFuncPtr3[Ptr[git_odb_stream], CString, size_t, CInt]]
      def write_=(
          value: CFuncPtr3[Ptr[git_odb_stream], CString, size_t, CInt]
      ): Unit = !struct.at7 =
        value.asInstanceOf[CFuncPtr3[Ptr[Byte], CString, size_t, CInt]]
      def finalize_write: CFuncPtr2[Ptr[git_odb_stream], Ptr[git_oid], CInt] =
        struct._8
          .asInstanceOf[CFuncPtr2[Ptr[git_odb_stream], Ptr[git_oid], CInt]]
      def finalize_write_=(
          value: CFuncPtr2[Ptr[git_odb_stream], Ptr[git_oid], CInt]
      ): Unit = !struct.at8 =
        value.asInstanceOf[CFuncPtr2[Ptr[Byte], Ptr[git_oid], CInt]]
      def free: CFuncPtr1[Ptr[git_odb_stream], Unit] =
        struct._9.asInstanceOf[CFuncPtr1[Ptr[git_odb_stream], Unit]]
      def free_=(value: CFuncPtr1[Ptr[git_odb_stream], Unit]): Unit =
        !struct.at9 = value.asInstanceOf[CFuncPtr1[Ptr[Byte], Unit]]

  opaque type git_odb_writepack = CStruct4[
    Ptr[git_odb_backend],
    CFuncPtr4[Ptr[Byte], Ptr[Byte], size_t, Ptr[git_indexer_progress], CInt],
    CFuncPtr2[Ptr[Byte], Ptr[git_indexer_progress], CInt],
    CFuncPtr1[Ptr[Byte], Unit]
  ]
  object git_odb_writepack:
    given _tag: Tag[git_odb_writepack] =
      Tag.materializeCStruct4Tag[Ptr[git_odb_backend], CFuncPtr4[Ptr[Byte], Ptr[
        Byte
      ], size_t, Ptr[git_indexer_progress], CInt], CFuncPtr2[Ptr[Byte], Ptr[
        git_indexer_progress
      ], CInt], CFuncPtr1[Ptr[Byte], Unit]]
    def apply()(using Zone): Ptr[git_odb_writepack] =
      scala.scalanative.unsafe.alloc[git_odb_writepack](1)
    def apply(
        backend: Ptr[git_odb_backend],
        append: CFuncPtr4[Ptr[git_odb_writepack], Ptr[Byte], size_t, Ptr[
          git_indexer_progress
        ], CInt],
        commit: CFuncPtr2[Ptr[git_odb_writepack], Ptr[
          git_indexer_progress
        ], CInt],
        free: CFuncPtr1[Ptr[git_odb_writepack], Unit]
    )(using Zone): Ptr[git_odb_writepack] =
      val ____ptr = apply()
      (!____ptr).backend = backend
      (!____ptr).append = append
      (!____ptr).commit = commit
      (!____ptr).free = free
      ____ptr
    extension (struct: git_odb_writepack)
      def backend: Ptr[git_odb_backend] = struct._1
      def backend_=(value: Ptr[git_odb_backend]): Unit = !struct.at1 = value
      def append: CFuncPtr4[Ptr[git_odb_writepack], Ptr[Byte], size_t, Ptr[
        git_indexer_progress
      ], CInt] = struct._2.asInstanceOf[CFuncPtr4[Ptr[git_odb_writepack], Ptr[
        Byte
      ], size_t, Ptr[git_indexer_progress], CInt]]
      def append_=(
          value: CFuncPtr4[Ptr[git_odb_writepack], Ptr[Byte], size_t, Ptr[
            git_indexer_progress
          ], CInt]
      ): Unit = !struct.at2 = value.asInstanceOf[CFuncPtr4[Ptr[Byte], Ptr[
        Byte
      ], size_t, Ptr[git_indexer_progress], CInt]]
      def commit
          : CFuncPtr2[Ptr[git_odb_writepack], Ptr[git_indexer_progress], CInt] =
        struct._3.asInstanceOf[CFuncPtr2[Ptr[git_odb_writepack], Ptr[
          git_indexer_progress
        ], CInt]]
      def commit_=(
          value: CFuncPtr2[Ptr[git_odb_writepack], Ptr[
            git_indexer_progress
          ], CInt]
      ): Unit = !struct.at3 = value
        .asInstanceOf[CFuncPtr2[Ptr[Byte], Ptr[git_indexer_progress], CInt]]
      def free: CFuncPtr1[Ptr[git_odb_writepack], Unit] =
        struct._4.asInstanceOf[CFuncPtr1[Ptr[git_odb_writepack], Unit]]
      def free_=(value: CFuncPtr1[Ptr[git_odb_writepack], Unit]): Unit =
        !struct.at4 = value.asInstanceOf[CFuncPtr1[Ptr[Byte], Unit]]

  opaque type git_oid =
    CStruct1[CArray[CUnsignedChar, Nat.Digit2[Nat._2, Nat._0]]]
  object git_oid:
    given _tag: Tag[git_oid] = Tag
      .materializeCStruct1Tag[CArray[CUnsignedChar, Nat.Digit2[Nat._2, Nat._0]]]
    def apply()(using Zone): Ptr[git_oid] =
      scala.scalanative.unsafe.alloc[git_oid](1)
    def apply(id: CArray[CUnsignedChar, Nat.Digit2[Nat._2, Nat._0]])(using
        Zone
    ): Ptr[git_oid] =
      val ____ptr = apply()
      (!____ptr).id = id
      ____ptr
    extension (struct: git_oid)
      def id: CArray[CUnsignedChar, Nat.Digit2[Nat._2, Nat._0]] = struct._1
      def id_=(value: CArray[CUnsignedChar, Nat.Digit2[Nat._2, Nat._0]]): Unit =
        !struct.at1 = value

  opaque type git_oid_shorten = CStruct0
  object git_oid_shorten:
    given _tag: Tag[git_oid_shorten] = Tag.materializeCStruct0Tag

  opaque type git_oidarray = CStruct2[Ptr[git_oid], size_t]
  object git_oidarray:
    given _tag: Tag[git_oidarray] =
      Tag.materializeCStruct2Tag[Ptr[git_oid], size_t]
    def apply()(using Zone): Ptr[git_oidarray] =
      scala.scalanative.unsafe.alloc[git_oidarray](1)
    def apply(ids: Ptr[git_oid], count: size_t)(using Zone): Ptr[git_oidarray] =
      val ____ptr = apply()
      (!____ptr).ids = ids
      (!____ptr).count = count
      ____ptr
    extension (struct: git_oidarray)
      def ids: Ptr[git_oid] = struct._1
      def ids_=(value: Ptr[git_oid]): Unit = !struct.at1 = value
      def count: size_t = struct._2
      def count_=(value: size_t): Unit = !struct.at2 = value

  opaque type git_packbuilder = CStruct0
  object git_packbuilder:
    given _tag: Tag[git_packbuilder] = Tag.materializeCStruct0Tag

  opaque type git_patch = CStruct0
  object git_patch:
    given _tag: Tag[git_patch] = Tag.materializeCStruct0Tag

  opaque type git_pathspec = CStruct0
  object git_pathspec:
    given _tag: Tag[git_pathspec] = Tag.materializeCStruct0Tag

  opaque type git_pathspec_match_list = CStruct0
  object git_pathspec_match_list:
    given _tag: Tag[git_pathspec_match_list] = Tag.materializeCStruct0Tag

  opaque type git_proxy_options = CStruct6[
    CUnsignedInt,
    git_proxy_t,
    CString,
    git_credential_acquire_cb,
    git_transport_certificate_check_cb,
    Ptr[Byte]
  ]
  object git_proxy_options:
    given _tag: Tag[git_proxy_options] = Tag.materializeCStruct6Tag[
      CUnsignedInt,
      git_proxy_t,
      CString,
      git_credential_acquire_cb,
      git_transport_certificate_check_cb,
      Ptr[Byte]
    ]
    def apply()(using Zone): Ptr[git_proxy_options] =
      scala.scalanative.unsafe.alloc[git_proxy_options](1)
    def apply(
        version: CUnsignedInt,
        `type`: git_proxy_t,
        url: CString,
        credentials: git_credential_acquire_cb,
        certificate_check: git_transport_certificate_check_cb,
        payload: Ptr[Byte]
    )(using Zone): Ptr[git_proxy_options] =
      val ____ptr = apply()
      (!____ptr).version = version
      (!____ptr).`type` = `type`
      (!____ptr).url = url
      (!____ptr).credentials = credentials
      (!____ptr).certificate_check = certificate_check
      (!____ptr).payload = payload
      ____ptr
    extension (struct: git_proxy_options)
      def version: CUnsignedInt = struct._1
      def version_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def `type`: git_proxy_t = struct._2
      def type_=(value: git_proxy_t): Unit = !struct.at2 = value
      def url: CString = struct._3
      def url_=(value: CString): Unit = !struct.at3 = value
      def credentials: git_credential_acquire_cb = struct._4
      def credentials_=(value: git_credential_acquire_cb): Unit = !struct.at4 =
        value
      def certificate_check: git_transport_certificate_check_cb = struct._5
      def certificate_check_=(value: git_transport_certificate_check_cb): Unit =
        !struct.at5 = value
      def payload: Ptr[Byte] = struct._6
      def payload_=(value: Ptr[Byte]): Unit = !struct.at6 = value

  opaque type git_push = CStruct0
  object git_push:
    given _tag: Tag[git_push] = Tag.materializeCStruct0Tag

  opaque type git_push_options = CStruct6[
    CUnsignedInt,
    CUnsignedInt,
    git_remote_callbacks,
    git_proxy_options,
    git_remote_redirect_t,
    git_strarray
  ]
  object git_push_options:
    given _tag: Tag[git_push_options] = Tag.materializeCStruct6Tag[
      CUnsignedInt,
      CUnsignedInt,
      git_remote_callbacks,
      git_proxy_options,
      git_remote_redirect_t,
      git_strarray
    ]
    def apply()(using Zone): Ptr[git_push_options] =
      scala.scalanative.unsafe.alloc[git_push_options](1)
    def apply(
        version: CUnsignedInt,
        pb_parallelism: CUnsignedInt,
        callbacks: git_remote_callbacks,
        proxy_opts: git_proxy_options,
        follow_redirects: git_remote_redirect_t,
        custom_headers: git_strarray
    )(using Zone): Ptr[git_push_options] =
      val ____ptr = apply()
      (!____ptr).version = version
      (!____ptr).pb_parallelism = pb_parallelism
      (!____ptr).callbacks = callbacks
      (!____ptr).proxy_opts = proxy_opts
      (!____ptr).follow_redirects = follow_redirects
      (!____ptr).custom_headers = custom_headers
      ____ptr
    extension (struct: git_push_options)
      def version: CUnsignedInt = struct._1
      def version_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def pb_parallelism: CUnsignedInt = struct._2
      def pb_parallelism_=(value: CUnsignedInt): Unit = !struct.at2 = value
      def callbacks: git_remote_callbacks = struct._3
      def callbacks_=(value: git_remote_callbacks): Unit = !struct.at3 = value
      def proxy_opts: git_proxy_options = struct._4
      def proxy_opts_=(value: git_proxy_options): Unit = !struct.at4 = value
      def follow_redirects: git_remote_redirect_t = struct._5
      def follow_redirects_=(value: git_remote_redirect_t): Unit = !struct.at5 =
        value
      def custom_headers: git_strarray = struct._6
      def custom_headers_=(value: git_strarray): Unit = !struct.at6 = value

  opaque type git_push_update = CStruct4[CString, CString, git_oid, git_oid]
  object git_push_update:
    given _tag: Tag[git_push_update] =
      Tag.materializeCStruct4Tag[CString, CString, git_oid, git_oid]
    def apply()(using Zone): Ptr[git_push_update] =
      scala.scalanative.unsafe.alloc[git_push_update](1)
    def apply(
        src_refname: CString,
        dst_refname: CString,
        src: git_oid,
        dst: git_oid
    )(using Zone): Ptr[git_push_update] =
      val ____ptr = apply()
      (!____ptr).src_refname = src_refname
      (!____ptr).dst_refname = dst_refname
      (!____ptr).src = src
      (!____ptr).dst = dst
      ____ptr
    extension (struct: git_push_update)
      def src_refname: CString = struct._1
      def src_refname_=(value: CString): Unit = !struct.at1 = value
      def dst_refname: CString = struct._2
      def dst_refname_=(value: CString): Unit = !struct.at2 = value
      def src: git_oid = struct._3
      def src_=(value: git_oid): Unit = !struct.at3 = value
      def dst: git_oid = struct._4
      def dst_=(value: git_oid): Unit = !struct.at4 = value

  opaque type git_rebase = CStruct0
  object git_rebase:
    given _tag: Tag[git_rebase] = Tag.materializeCStruct0Tag

  opaque type git_rebase_operation =
    CStruct3[git_rebase_operation_t, git_oid, CString]
  object git_rebase_operation:
    given _tag: Tag[git_rebase_operation] =
      Tag.materializeCStruct3Tag[git_rebase_operation_t, git_oid, CString]
    def apply()(using Zone): Ptr[git_rebase_operation] =
      scala.scalanative.unsafe.alloc[git_rebase_operation](1)
    def apply(`type`: git_rebase_operation_t, id: git_oid, exec: CString)(using
        Zone
    ): Ptr[git_rebase_operation] =
      val ____ptr = apply()
      (!____ptr).`type` = `type`
      (!____ptr).id = id
      (!____ptr).exec = exec
      ____ptr
    extension (struct: git_rebase_operation)
      def `type`: git_rebase_operation_t = struct._1
      def type_=(value: git_rebase_operation_t): Unit = !struct.at1 = value
      def id: git_oid = struct._2
      def id_=(value: git_oid): Unit = !struct.at2 = value
      def exec: CString = struct._3
      def exec_=(value: CString): Unit = !struct.at3 = value

  opaque type git_rebase_options = CStruct9[
    CUnsignedInt,
    CInt,
    CInt,
    CString,
    git_merge_options,
    git_checkout_options,
    git_commit_create_cb,
    CFuncPtr4[Ptr[git_buf], Ptr[git_buf], CString, Ptr[Byte], CInt],
    Ptr[Byte]
  ]
  object git_rebase_options:
    given _tag: Tag[git_rebase_options] = Tag.materializeCStruct9Tag[
      CUnsignedInt,
      CInt,
      CInt,
      CString,
      git_merge_options,
      git_checkout_options,
      git_commit_create_cb,
      CFuncPtr4[Ptr[git_buf], Ptr[git_buf], CString, Ptr[Byte], CInt],
      Ptr[Byte]
    ]
    def apply()(using Zone): Ptr[git_rebase_options] =
      scala.scalanative.unsafe.alloc[git_rebase_options](1)
    def apply(
        version: CUnsignedInt,
        quiet: CInt,
        inmemory: CInt,
        rewrite_notes_ref: CString,
        merge_options: git_merge_options,
        checkout_options: git_checkout_options,
        commit_create_cb: git_commit_create_cb,
        signing_cb: CFuncPtr4[Ptr[git_buf], Ptr[git_buf], CString, Ptr[
          Byte
        ], CInt],
        payload: Ptr[Byte]
    )(using Zone): Ptr[git_rebase_options] =
      val ____ptr = apply()
      (!____ptr).version = version
      (!____ptr).quiet = quiet
      (!____ptr).inmemory = inmemory
      (!____ptr).rewrite_notes_ref = rewrite_notes_ref
      (!____ptr).merge_options = merge_options
      (!____ptr).checkout_options = checkout_options
      (!____ptr).commit_create_cb = commit_create_cb
      (!____ptr).signing_cb = signing_cb
      (!____ptr).payload = payload
      ____ptr
    extension (struct: git_rebase_options)
      def version: CUnsignedInt = struct._1
      def version_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def quiet: CInt = struct._2
      def quiet_=(value: CInt): Unit = !struct.at2 = value
      def inmemory: CInt = struct._3
      def inmemory_=(value: CInt): Unit = !struct.at3 = value
      def rewrite_notes_ref: CString = struct._4
      def rewrite_notes_ref_=(value: CString): Unit = !struct.at4 = value
      def merge_options: git_merge_options = struct._5
      def merge_options_=(value: git_merge_options): Unit = !struct.at5 = value
      def checkout_options: git_checkout_options = struct._6
      def checkout_options_=(value: git_checkout_options): Unit = !struct.at6 =
        value
      def commit_create_cb: git_commit_create_cb = struct._7
      def commit_create_cb_=(value: git_commit_create_cb): Unit = !struct.at7 =
        value
      def signing_cb
          : CFuncPtr4[Ptr[git_buf], Ptr[git_buf], CString, Ptr[Byte], CInt] =
        struct._8
      def signing_cb_=(
          value: CFuncPtr4[Ptr[git_buf], Ptr[git_buf], CString, Ptr[Byte], CInt]
      ): Unit = !struct.at8 = value
      def payload: Ptr[Byte] = struct._9
      def payload_=(value: Ptr[Byte]): Unit = !struct.at9 = value

  opaque type git_refdb = CStruct0
  object git_refdb:
    given _tag: Tag[git_refdb] = Tag.materializeCStruct0Tag

  opaque type git_refdb_backend = CStruct0
  object git_refdb_backend:
    given _tag: Tag[git_refdb_backend] = Tag.materializeCStruct0Tag

  opaque type git_reference = CStruct0
  object git_reference:
    given _tag: Tag[git_reference] = Tag.materializeCStruct0Tag

  opaque type git_reference_iterator = CStruct0
  object git_reference_iterator:
    given _tag: Tag[git_reference_iterator] = Tag.materializeCStruct0Tag

  opaque type git_reflog = CStruct0
  object git_reflog:
    given _tag: Tag[git_reflog] = Tag.materializeCStruct0Tag

  opaque type git_reflog_entry = CStruct0
  object git_reflog_entry:
    given _tag: Tag[git_reflog_entry] = Tag.materializeCStruct0Tag

  opaque type git_refspec = CStruct0
  object git_refspec:
    given _tag: Tag[git_refspec] = Tag.materializeCStruct0Tag

  opaque type git_remote = CStruct0
  object git_remote:
    given _tag: Tag[git_remote] = Tag.materializeCStruct0Tag

  opaque type git_remote_callbacks = CStruct15[
    CUnsignedInt,
    git_transport_message_cb,
    CFuncPtr2[git_remote_completion_t, Ptr[Byte], CInt],
    git_credential_acquire_cb,
    git_transport_certificate_check_cb,
    git_indexer_progress_cb,
    CFuncPtr4[CString, Ptr[git_oid], Ptr[git_oid], Ptr[Byte], CInt],
    git_packbuilder_progress,
    git_push_transfer_progress_cb,
    git_push_update_reference_cb,
    git_push_negotiation,
    git_transport_cb,
    git_remote_ready_cb,
    Ptr[Byte],
    git_url_resolve_cb
  ]
  object git_remote_callbacks:
    given _tag: Tag[git_remote_callbacks] = Tag.materializeCStruct15Tag[
      CUnsignedInt,
      git_transport_message_cb,
      CFuncPtr2[git_remote_completion_t, Ptr[Byte], CInt],
      git_credential_acquire_cb,
      git_transport_certificate_check_cb,
      git_indexer_progress_cb,
      CFuncPtr4[CString, Ptr[git_oid], Ptr[git_oid], Ptr[Byte], CInt],
      git_packbuilder_progress,
      git_push_transfer_progress_cb,
      git_push_update_reference_cb,
      git_push_negotiation,
      git_transport_cb,
      git_remote_ready_cb,
      Ptr[Byte],
      git_url_resolve_cb
    ]
    def apply()(using Zone): Ptr[git_remote_callbacks] =
      scala.scalanative.unsafe.alloc[git_remote_callbacks](1)
    def apply(
        version: CUnsignedInt,
        sideband_progress: git_transport_message_cb,
        completion: CFuncPtr2[git_remote_completion_t, Ptr[Byte], CInt],
        credentials: git_credential_acquire_cb,
        certificate_check: git_transport_certificate_check_cb,
        transfer_progress: git_indexer_progress_cb,
        update_tips: CFuncPtr4[CString, Ptr[git_oid], Ptr[git_oid], Ptr[
          Byte
        ], CInt],
        pack_progress: git_packbuilder_progress,
        push_transfer_progress: git_push_transfer_progress_cb,
        push_update_reference: git_push_update_reference_cb,
        push_negotiation: git_push_negotiation,
        transport: git_transport_cb,
        remote_ready: git_remote_ready_cb,
        payload: Ptr[Byte],
        resolve_url: git_url_resolve_cb
    )(using Zone): Ptr[git_remote_callbacks] =
      val ____ptr = apply()
      (!____ptr).version = version
      (!____ptr).sideband_progress = sideband_progress
      (!____ptr).completion = completion
      (!____ptr).credentials = credentials
      (!____ptr).certificate_check = certificate_check
      (!____ptr).transfer_progress = transfer_progress
      (!____ptr).update_tips = update_tips
      (!____ptr).pack_progress = pack_progress
      (!____ptr).push_transfer_progress = push_transfer_progress
      (!____ptr).push_update_reference = push_update_reference
      (!____ptr).push_negotiation = push_negotiation
      (!____ptr).transport = transport
      (!____ptr).remote_ready = remote_ready
      (!____ptr).payload = payload
      (!____ptr).resolve_url = resolve_url
      ____ptr
    extension (struct: git_remote_callbacks)
      def version: CUnsignedInt = struct._1
      def version_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def sideband_progress: git_transport_message_cb = struct._2
      def sideband_progress_=(value: git_transport_message_cb): Unit =
        !struct.at2 = value
      def completion: CFuncPtr2[git_remote_completion_t, Ptr[Byte], CInt] =
        struct._3
      def completion_=(
          value: CFuncPtr2[git_remote_completion_t, Ptr[Byte], CInt]
      ): Unit = !struct.at3 = value
      def credentials: git_credential_acquire_cb = struct._4
      def credentials_=(value: git_credential_acquire_cb): Unit = !struct.at4 =
        value
      def certificate_check: git_transport_certificate_check_cb = struct._5
      def certificate_check_=(value: git_transport_certificate_check_cb): Unit =
        !struct.at5 = value
      def transfer_progress: git_indexer_progress_cb = struct._6
      def transfer_progress_=(value: git_indexer_progress_cb): Unit =
        !struct.at6 = value
      def update_tips
          : CFuncPtr4[CString, Ptr[git_oid], Ptr[git_oid], Ptr[Byte], CInt] =
        struct._7
      def update_tips_=(
          value: CFuncPtr4[CString, Ptr[git_oid], Ptr[git_oid], Ptr[Byte], CInt]
      ): Unit = !struct.at7 = value
      def pack_progress: git_packbuilder_progress = struct._8
      def pack_progress_=(value: git_packbuilder_progress): Unit = !struct.at8 =
        value
      def push_transfer_progress: git_push_transfer_progress_cb = struct._9
      def push_transfer_progress_=(value: git_push_transfer_progress_cb): Unit =
        !struct.at9 = value
      def push_update_reference: git_push_update_reference_cb = struct._10
      def push_update_reference_=(value: git_push_update_reference_cb): Unit =
        !struct.at10 = value
      def push_negotiation: git_push_negotiation = struct._11
      def push_negotiation_=(value: git_push_negotiation): Unit = !struct.at11 =
        value
      def transport: git_transport_cb = struct._12
      def transport_=(value: git_transport_cb): Unit = !struct.at12 = value
      def remote_ready: git_remote_ready_cb = struct._13
      def remote_ready_=(value: git_remote_ready_cb): Unit = !struct.at13 =
        value
      def payload: Ptr[Byte] = struct._14
      def payload_=(value: Ptr[Byte]): Unit = !struct.at14 = value
      def resolve_url: git_url_resolve_cb = struct._15
      def resolve_url_=(value: git_url_resolve_cb): Unit = !struct.at15 = value

  opaque type git_remote_connect_options = CStruct5[
    CUnsignedInt,
    git_remote_callbacks,
    git_proxy_options,
    git_remote_redirect_t,
    git_strarray
  ]
  object git_remote_connect_options:
    given _tag: Tag[git_remote_connect_options] = Tag.materializeCStruct5Tag[
      CUnsignedInt,
      git_remote_callbacks,
      git_proxy_options,
      git_remote_redirect_t,
      git_strarray
    ]
    def apply()(using Zone): Ptr[git_remote_connect_options] =
      scala.scalanative.unsafe.alloc[git_remote_connect_options](1)
    def apply(
        version: CUnsignedInt,
        callbacks: git_remote_callbacks,
        proxy_opts: git_proxy_options,
        follow_redirects: git_remote_redirect_t,
        custom_headers: git_strarray
    )(using Zone): Ptr[git_remote_connect_options] =
      val ____ptr = apply()
      (!____ptr).version = version
      (!____ptr).callbacks = callbacks
      (!____ptr).proxy_opts = proxy_opts
      (!____ptr).follow_redirects = follow_redirects
      (!____ptr).custom_headers = custom_headers
      ____ptr
    extension (struct: git_remote_connect_options)
      def version: CUnsignedInt = struct._1
      def version_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def callbacks: git_remote_callbacks = struct._2
      def callbacks_=(value: git_remote_callbacks): Unit = !struct.at2 = value
      def proxy_opts: git_proxy_options = struct._3
      def proxy_opts_=(value: git_proxy_options): Unit = !struct.at3 = value
      def follow_redirects: git_remote_redirect_t = struct._4
      def follow_redirects_=(value: git_remote_redirect_t): Unit = !struct.at4 =
        value
      def custom_headers: git_strarray = struct._5
      def custom_headers_=(value: git_strarray): Unit = !struct.at5 = value

  opaque type git_remote_create_options =
    CStruct5[CUnsignedInt, Ptr[git_repository], CString, CString, CUnsignedInt]
  object git_remote_create_options:
    given _tag: Tag[git_remote_create_options] =
      Tag.materializeCStruct5Tag[CUnsignedInt, Ptr[
        git_repository
      ], CString, CString, CUnsignedInt]
    def apply()(using Zone): Ptr[git_remote_create_options] =
      scala.scalanative.unsafe.alloc[git_remote_create_options](1)
    def apply(
        version: CUnsignedInt,
        repository: Ptr[git_repository],
        name: CString,
        fetchspec: CString,
        flags: CUnsignedInt
    )(using Zone): Ptr[git_remote_create_options] =
      val ____ptr = apply()
      (!____ptr).version = version
      (!____ptr).repository = repository
      (!____ptr).name = name
      (!____ptr).fetchspec = fetchspec
      (!____ptr).flags = flags
      ____ptr
    extension (struct: git_remote_create_options)
      def version: CUnsignedInt = struct._1
      def version_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def repository: Ptr[git_repository] = struct._2
      def repository_=(value: Ptr[git_repository]): Unit = !struct.at2 = value
      def name: CString = struct._3
      def name_=(value: CString): Unit = !struct.at3 = value
      def fetchspec: CString = struct._4
      def fetchspec_=(value: CString): Unit = !struct.at4 = value
      def flags: CUnsignedInt = struct._5
      def flags_=(value: CUnsignedInt): Unit = !struct.at5 = value

  opaque type git_remote_head =
    CStruct5[CInt, git_oid, git_oid, CString, CString]
  object git_remote_head:
    given _tag: Tag[git_remote_head] =
      Tag.materializeCStruct5Tag[CInt, git_oid, git_oid, CString, CString]
    def apply()(using Zone): Ptr[git_remote_head] =
      scala.scalanative.unsafe.alloc[git_remote_head](1)
    def apply(
        local: CInt,
        oid: git_oid,
        loid: git_oid,
        name: CString,
        symref_target: CString
    )(using Zone): Ptr[git_remote_head] =
      val ____ptr = apply()
      (!____ptr).local = local
      (!____ptr).oid = oid
      (!____ptr).loid = loid
      (!____ptr).name = name
      (!____ptr).symref_target = symref_target
      ____ptr
    extension (struct: git_remote_head)
      def local: CInt = struct._1
      def local_=(value: CInt): Unit = !struct.at1 = value
      def oid: git_oid = struct._2
      def oid_=(value: git_oid): Unit = !struct.at2 = value
      def loid: git_oid = struct._3
      def loid_=(value: git_oid): Unit = !struct.at3 = value
      def name: CString = struct._4
      def name_=(value: CString): Unit = !struct.at4 = value
      def symref_target: CString = struct._5
      def symref_target_=(value: CString): Unit = !struct.at5 = value

  opaque type git_repository = CStruct0
  object git_repository:
    given _tag: Tag[git_repository] = Tag.materializeCStruct0Tag

  opaque type git_repository_init_options = CStruct8[
    CUnsignedInt,
    uint32_t,
    uint32_t,
    CString,
    CString,
    CString,
    CString,
    CString
  ]
  object git_repository_init_options:
    given _tag: Tag[git_repository_init_options] = Tag.materializeCStruct8Tag[
      CUnsignedInt,
      uint32_t,
      uint32_t,
      CString,
      CString,
      CString,
      CString,
      CString
    ]
    def apply()(using Zone): Ptr[git_repository_init_options] =
      scala.scalanative.unsafe.alloc[git_repository_init_options](1)
    def apply(
        version: CUnsignedInt,
        flags: uint32_t,
        mode: uint32_t,
        workdir_path: CString,
        description: CString,
        template_path: CString,
        initial_head: CString,
        origin_url: CString
    )(using Zone): Ptr[git_repository_init_options] =
      val ____ptr = apply()
      (!____ptr).version = version
      (!____ptr).flags = flags
      (!____ptr).mode = mode
      (!____ptr).workdir_path = workdir_path
      (!____ptr).description = description
      (!____ptr).template_path = template_path
      (!____ptr).initial_head = initial_head
      (!____ptr).origin_url = origin_url
      ____ptr
    extension (struct: git_repository_init_options)
      def version: CUnsignedInt = struct._1
      def version_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def flags: uint32_t = struct._2
      def flags_=(value: uint32_t): Unit = !struct.at2 = value
      def mode: uint32_t = struct._3
      def mode_=(value: uint32_t): Unit = !struct.at3 = value
      def workdir_path: CString = struct._4
      def workdir_path_=(value: CString): Unit = !struct.at4 = value
      def description: CString = struct._5
      def description_=(value: CString): Unit = !struct.at5 = value
      def template_path: CString = struct._6
      def template_path_=(value: CString): Unit = !struct.at6 = value
      def initial_head: CString = struct._7
      def initial_head_=(value: CString): Unit = !struct.at7 = value
      def origin_url: CString = struct._8
      def origin_url_=(value: CString): Unit = !struct.at8 = value

  opaque type git_revert_options = CStruct4[
    CUnsignedInt,
    CUnsignedInt,
    git_merge_options,
    git_checkout_options
  ]
  object git_revert_options:
    given _tag: Tag[git_revert_options] = Tag.materializeCStruct4Tag[
      CUnsignedInt,
      CUnsignedInt,
      git_merge_options,
      git_checkout_options
    ]
    def apply()(using Zone): Ptr[git_revert_options] =
      scala.scalanative.unsafe.alloc[git_revert_options](1)
    def apply(
        version: CUnsignedInt,
        mainline: CUnsignedInt,
        merge_opts: git_merge_options,
        checkout_opts: git_checkout_options
    )(using Zone): Ptr[git_revert_options] =
      val ____ptr = apply()
      (!____ptr).version = version
      (!____ptr).mainline = mainline
      (!____ptr).merge_opts = merge_opts
      (!____ptr).checkout_opts = checkout_opts
      ____ptr
    extension (struct: git_revert_options)
      def version: CUnsignedInt = struct._1
      def version_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def mainline: CUnsignedInt = struct._2
      def mainline_=(value: CUnsignedInt): Unit = !struct.at2 = value
      def merge_opts: git_merge_options = struct._3
      def merge_opts_=(value: git_merge_options): Unit = !struct.at3 = value
      def checkout_opts: git_checkout_options = struct._4
      def checkout_opts_=(value: git_checkout_options): Unit = !struct.at4 =
        value

  opaque type git_revspec =
    CStruct3[Ptr[git_object], Ptr[git_object], CUnsignedInt]
  object git_revspec:
    given _tag: Tag[git_revspec] =
      Tag.materializeCStruct3Tag[Ptr[git_object], Ptr[git_object], CUnsignedInt]
    def apply()(using Zone): Ptr[git_revspec] =
      scala.scalanative.unsafe.alloc[git_revspec](1)
    def apply(from: Ptr[git_object], to: Ptr[git_object], flags: CUnsignedInt)(
        using Zone
    ): Ptr[git_revspec] =
      val ____ptr = apply()
      (!____ptr).from = from
      (!____ptr).to = to
      (!____ptr).flags = flags
      ____ptr
    extension (struct: git_revspec)
      def from: Ptr[git_object] = struct._1
      def from_=(value: Ptr[git_object]): Unit = !struct.at1 = value
      def to: Ptr[git_object] = struct._2
      def to_=(value: Ptr[git_object]): Unit = !struct.at2 = value
      def flags: CUnsignedInt = struct._3
      def flags_=(value: CUnsignedInt): Unit = !struct.at3 = value

  opaque type git_revwalk = CStruct0
  object git_revwalk:
    given _tag: Tag[git_revwalk] = Tag.materializeCStruct0Tag

  opaque type git_signature = CStruct3[CString, CString, git_time]
  object git_signature:
    given _tag: Tag[git_signature] =
      Tag.materializeCStruct3Tag[CString, CString, git_time]
    def apply()(using Zone): Ptr[git_signature] =
      scala.scalanative.unsafe.alloc[git_signature](1)
    def apply(name: CString, email: CString, when: git_time)(using
        Zone
    ): Ptr[git_signature] =
      val ____ptr = apply()
      (!____ptr).name = name
      (!____ptr).email = email
      (!____ptr).when = when
      ____ptr
    extension (struct: git_signature)
      def name: CString = struct._1
      def name_=(value: CString): Unit = !struct.at1 = value
      def email: CString = struct._2
      def email_=(value: CString): Unit = !struct.at2 = value
      def when: git_time = struct._3
      def when_=(value: git_time): Unit = !struct.at3 = value

  opaque type git_stash_apply_options = CStruct5[
    CUnsignedInt,
    uint32_t,
    git_checkout_options,
    git_stash_apply_progress_cb,
    Ptr[Byte]
  ]
  object git_stash_apply_options:
    given _tag: Tag[git_stash_apply_options] = Tag.materializeCStruct5Tag[
      CUnsignedInt,
      uint32_t,
      git_checkout_options,
      git_stash_apply_progress_cb,
      Ptr[Byte]
    ]
    def apply()(using Zone): Ptr[git_stash_apply_options] =
      scala.scalanative.unsafe.alloc[git_stash_apply_options](1)
    def apply(
        version: CUnsignedInt,
        flags: uint32_t,
        checkout_options: git_checkout_options,
        progress_cb: git_stash_apply_progress_cb,
        progress_payload: Ptr[Byte]
    )(using Zone): Ptr[git_stash_apply_options] =
      val ____ptr = apply()
      (!____ptr).version = version
      (!____ptr).flags = flags
      (!____ptr).checkout_options = checkout_options
      (!____ptr).progress_cb = progress_cb
      (!____ptr).progress_payload = progress_payload
      ____ptr
    extension (struct: git_stash_apply_options)
      def version: CUnsignedInt = struct._1
      def version_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def flags: uint32_t = struct._2
      def flags_=(value: uint32_t): Unit = !struct.at2 = value
      def checkout_options: git_checkout_options = struct._3
      def checkout_options_=(value: git_checkout_options): Unit = !struct.at3 =
        value
      def progress_cb: git_stash_apply_progress_cb = struct._4
      def progress_cb_=(value: git_stash_apply_progress_cb): Unit =
        !struct.at4 = value
      def progress_payload: Ptr[Byte] = struct._5
      def progress_payload_=(value: Ptr[Byte]): Unit = !struct.at5 = value

  opaque type git_status_entry =
    CStruct3[git_status_t, Ptr[git_diff_delta], Ptr[git_diff_delta]]
  object git_status_entry:
    given _tag: Tag[git_status_entry] =
      Tag.materializeCStruct3Tag[git_status_t, Ptr[git_diff_delta], Ptr[
        git_diff_delta
      ]]
    def apply()(using Zone): Ptr[git_status_entry] =
      scala.scalanative.unsafe.alloc[git_status_entry](1)
    def apply(
        status: git_status_t,
        head_to_index: Ptr[git_diff_delta],
        index_to_workdir: Ptr[git_diff_delta]
    )(using Zone): Ptr[git_status_entry] =
      val ____ptr = apply()
      (!____ptr).status = status
      (!____ptr).head_to_index = head_to_index
      (!____ptr).index_to_workdir = index_to_workdir
      ____ptr
    extension (struct: git_status_entry)
      def status: git_status_t = struct._1
      def status_=(value: git_status_t): Unit = !struct.at1 = value
      def head_to_index: Ptr[git_diff_delta] = struct._2
      def head_to_index_=(value: Ptr[git_diff_delta]): Unit = !struct.at2 =
        value
      def index_to_workdir: Ptr[git_diff_delta] = struct._3
      def index_to_workdir_=(value: Ptr[git_diff_delta]): Unit = !struct.at3 =
        value

  opaque type git_status_list = CStruct0
  object git_status_list:
    given _tag: Tag[git_status_list] = Tag.materializeCStruct0Tag

  opaque type git_status_options =
    CStruct6[CUnsignedInt, git_status_show_t, CUnsignedInt, git_strarray, Ptr[
      git_tree
    ], uint16_t]
  object git_status_options:
    given _tag: Tag[git_status_options] = Tag.materializeCStruct6Tag[
      CUnsignedInt,
      git_status_show_t,
      CUnsignedInt,
      git_strarray,
      Ptr[git_tree],
      uint16_t
    ]
    def apply()(using Zone): Ptr[git_status_options] =
      scala.scalanative.unsafe.alloc[git_status_options](1)
    def apply(
        version: CUnsignedInt,
        show: git_status_show_t,
        flags: CUnsignedInt,
        pathspec: git_strarray,
        baseline: Ptr[git_tree],
        rename_threshold: uint16_t
    )(using Zone): Ptr[git_status_options] =
      val ____ptr = apply()
      (!____ptr).version = version
      (!____ptr).show = show
      (!____ptr).flags = flags
      (!____ptr).pathspec = pathspec
      (!____ptr).baseline = baseline
      (!____ptr).rename_threshold = rename_threshold
      ____ptr
    extension (struct: git_status_options)
      def version: CUnsignedInt = struct._1
      def version_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def show: git_status_show_t = struct._2
      def show_=(value: git_status_show_t): Unit = !struct.at2 = value
      def flags: CUnsignedInt = struct._3
      def flags_=(value: CUnsignedInt): Unit = !struct.at3 = value
      def pathspec: git_strarray = struct._4
      def pathspec_=(value: git_strarray): Unit = !struct.at4 = value
      def baseline: Ptr[git_tree] = struct._5
      def baseline_=(value: Ptr[git_tree]): Unit = !struct.at5 = value
      def rename_threshold: uint16_t = struct._6
      def rename_threshold_=(value: uint16_t): Unit = !struct.at6 = value

  opaque type git_strarray = CStruct2[Ptr[CString], size_t]
  object git_strarray:
    given _tag: Tag[git_strarray] =
      Tag.materializeCStruct2Tag[Ptr[CString], size_t]
    def apply()(using Zone): Ptr[git_strarray] =
      scala.scalanative.unsafe.alloc[git_strarray](1)
    def apply(strings: Ptr[CString], count: size_t)(using
        Zone
    ): Ptr[git_strarray] =
      val ____ptr = apply()
      (!____ptr).strings = strings
      (!____ptr).count = count
      ____ptr
    extension (struct: git_strarray)
      def strings: Ptr[CString] = struct._1
      def strings_=(value: Ptr[CString]): Unit = !struct.at1 = value
      def count: size_t = struct._2
      def count_=(value: size_t): Unit = !struct.at2 = value

  opaque type git_submodule = CStruct0
  object git_submodule:
    given _tag: Tag[git_submodule] = Tag.materializeCStruct0Tag

  opaque type git_submodule_update_options =
    CStruct4[CUnsignedInt, git_checkout_options, git_fetch_options, CInt]
  object git_submodule_update_options:
    given _tag: Tag[git_submodule_update_options] = Tag.materializeCStruct4Tag[
      CUnsignedInt,
      git_checkout_options,
      git_fetch_options,
      CInt
    ]
    def apply()(using Zone): Ptr[git_submodule_update_options] =
      scala.scalanative.unsafe.alloc[git_submodule_update_options](1)
    def apply(
        version: CUnsignedInt,
        checkout_opts: git_checkout_options,
        fetch_opts: git_fetch_options,
        allow_fetch: CInt
    )(using Zone): Ptr[git_submodule_update_options] =
      val ____ptr = apply()
      (!____ptr).version = version
      (!____ptr).checkout_opts = checkout_opts
      (!____ptr).fetch_opts = fetch_opts
      (!____ptr).allow_fetch = allow_fetch
      ____ptr
    extension (struct: git_submodule_update_options)
      def version: CUnsignedInt = struct._1
      def version_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def checkout_opts: git_checkout_options = struct._2
      def checkout_opts_=(value: git_checkout_options): Unit = !struct.at2 =
        value
      def fetch_opts: git_fetch_options = struct._3
      def fetch_opts_=(value: git_fetch_options): Unit = !struct.at3 = value
      def allow_fetch: CInt = struct._4
      def allow_fetch_=(value: CInt): Unit = !struct.at4 = value

  opaque type git_tag = CStruct0
  object git_tag:
    given _tag: Tag[git_tag] = Tag.materializeCStruct0Tag

  opaque type git_time = CStruct3[git_time_t, CInt, CChar]
  object git_time:
    given _tag: Tag[git_time] =
      Tag.materializeCStruct3Tag[git_time_t, CInt, CChar]
    def apply()(using Zone): Ptr[git_time] =
      scala.scalanative.unsafe.alloc[git_time](1)
    def apply(time: git_time_t, offset: CInt, sign: CChar)(using
        Zone
    ): Ptr[git_time] =
      val ____ptr = apply()
      (!____ptr).time = time
      (!____ptr).offset = offset
      (!____ptr).sign = sign
      ____ptr
    extension (struct: git_time)
      def time: git_time_t = struct._1
      def time_=(value: git_time_t): Unit = !struct.at1 = value
      def offset: CInt = struct._2
      def offset_=(value: CInt): Unit = !struct.at2 = value
      def sign: CChar = struct._3
      def sign_=(value: CChar): Unit = !struct.at3 = value

  opaque type git_transaction = CStruct0
  object git_transaction:
    given _tag: Tag[git_transaction] = Tag.materializeCStruct0Tag

  opaque type git_transport = CStruct0
  object git_transport:
    given _tag: Tag[git_transport] = Tag.materializeCStruct0Tag

  opaque type git_tree = CStruct0
  object git_tree:
    given _tag: Tag[git_tree] = Tag.materializeCStruct0Tag

  opaque type git_tree_entry = CStruct0
  object git_tree_entry:
    given _tag: Tag[git_tree_entry] = Tag.materializeCStruct0Tag

  opaque type git_tree_update =
    CStruct4[git_tree_update_t, git_oid, git_filemode_t, CString]
  object git_tree_update:
    given _tag: Tag[git_tree_update] = Tag.materializeCStruct4Tag[
      git_tree_update_t,
      git_oid,
      git_filemode_t,
      CString
    ]
    def apply()(using Zone): Ptr[git_tree_update] =
      scala.scalanative.unsafe.alloc[git_tree_update](1)
    def apply(
        action: git_tree_update_t,
        id: git_oid,
        filemode: git_filemode_t,
        path: CString
    )(using Zone): Ptr[git_tree_update] =
      val ____ptr = apply()
      (!____ptr).action = action
      (!____ptr).id = id
      (!____ptr).filemode = filemode
      (!____ptr).path = path
      ____ptr
    extension (struct: git_tree_update)
      def action: git_tree_update_t = struct._1
      def action_=(value: git_tree_update_t): Unit = !struct.at1 = value
      def id: git_oid = struct._2
      def id_=(value: git_oid): Unit = !struct.at2 = value
      def filemode: git_filemode_t = struct._3
      def filemode_=(value: git_filemode_t): Unit = !struct.at3 = value
      def path: CString = struct._4
      def path_=(value: CString): Unit = !struct.at4 = value

  opaque type git_treebuilder = CStruct0
  object git_treebuilder:
    given _tag: Tag[git_treebuilder] = Tag.materializeCStruct0Tag

  opaque type git_worktree = CStruct0
  object git_worktree:
    given _tag: Tag[git_worktree] = Tag.materializeCStruct0Tag

  opaque type git_worktree_add_options =
    CStruct4[CUnsignedInt, CInt, Ptr[git_reference], git_checkout_options]
  object git_worktree_add_options:
    given _tag: Tag[git_worktree_add_options] =
      Tag.materializeCStruct4Tag[CUnsignedInt, CInt, Ptr[
        git_reference
      ], git_checkout_options]
    def apply()(using Zone): Ptr[git_worktree_add_options] =
      scala.scalanative.unsafe.alloc[git_worktree_add_options](1)
    def apply(
        version: CUnsignedInt,
        lock: CInt,
        ref: Ptr[git_reference],
        checkout_options: git_checkout_options
    )(using Zone): Ptr[git_worktree_add_options] =
      val ____ptr = apply()
      (!____ptr).version = version
      (!____ptr).lock = lock
      (!____ptr).ref = ref
      (!____ptr).checkout_options = checkout_options
      ____ptr
    extension (struct: git_worktree_add_options)
      def version: CUnsignedInt = struct._1
      def version_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def lock: CInt = struct._2
      def lock_=(value: CInt): Unit = !struct.at2 = value
      def ref: Ptr[git_reference] = struct._3
      def ref_=(value: Ptr[git_reference]): Unit = !struct.at3 = value
      def checkout_options: git_checkout_options = struct._4
      def checkout_options_=(value: git_checkout_options): Unit = !struct.at4 =
        value

  opaque type git_worktree_prune_options = CStruct2[CUnsignedInt, uint32_t]
  object git_worktree_prune_options:
    given _tag: Tag[git_worktree_prune_options] =
      Tag.materializeCStruct2Tag[CUnsignedInt, uint32_t]
    def apply()(using Zone): Ptr[git_worktree_prune_options] =
      scala.scalanative.unsafe.alloc[git_worktree_prune_options](1)
    def apply(version: CUnsignedInt, flags: uint32_t)(using
        Zone
    ): Ptr[git_worktree_prune_options] =
      val ____ptr = apply()
      (!____ptr).version = version
      (!____ptr).flags = flags
      ____ptr
    extension (struct: git_worktree_prune_options)
      def version: CUnsignedInt = struct._1
      def version_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def flags: uint32_t = struct._2
      def flags_=(value: uint32_t): Unit = !struct.at2 = value

  opaque type git_writestream =
    CStruct3[CFuncPtr3[Ptr[Byte], CString, size_t, CInt], CFuncPtr1[Ptr[
      Byte
    ], CInt], CFuncPtr1[Ptr[Byte], Unit]]
  object git_writestream:
    given _tag: Tag[git_writestream] = Tag.materializeCStruct3Tag[CFuncPtr3[
      Ptr[Byte],
      CString,
      size_t,
      CInt
    ], CFuncPtr1[Ptr[Byte], CInt], CFuncPtr1[Ptr[Byte], Unit]]
    def apply()(using Zone): Ptr[git_writestream] =
      scala.scalanative.unsafe.alloc[git_writestream](1)
    def apply(
        write: CFuncPtr3[Ptr[git_writestream], CString, size_t, CInt],
        close: CFuncPtr1[Ptr[git_writestream], CInt],
        free: CFuncPtr1[Ptr[git_writestream], Unit]
    )(using Zone): Ptr[git_writestream] =
      val ____ptr = apply()
      (!____ptr).write = write
      (!____ptr).close = close
      (!____ptr).free = free
      ____ptr
    extension (struct: git_writestream)
      def write: CFuncPtr3[Ptr[git_writestream], CString, size_t, CInt] =
        struct._1
          .asInstanceOf[CFuncPtr3[Ptr[git_writestream], CString, size_t, CInt]]
      def write_=(
          value: CFuncPtr3[Ptr[git_writestream], CString, size_t, CInt]
      ): Unit = !struct.at1 =
        value.asInstanceOf[CFuncPtr3[Ptr[Byte], CString, size_t, CInt]]
      def close: CFuncPtr1[Ptr[git_writestream], CInt] =
        struct._2.asInstanceOf[CFuncPtr1[Ptr[git_writestream], CInt]]
      def close_=(value: CFuncPtr1[Ptr[git_writestream], CInt]): Unit =
        !struct.at2 = value.asInstanceOf[CFuncPtr1[Ptr[Byte], CInt]]
      def free: CFuncPtr1[Ptr[git_writestream], Unit] =
        struct._3.asInstanceOf[CFuncPtr1[Ptr[git_writestream], Unit]]
      def free_=(value: CFuncPtr1[Ptr[git_writestream], Unit]): Unit =
        !struct.at3 = value.asInstanceOf[CFuncPtr1[Ptr[Byte], Unit]]
@link("git2")
@extern
private[libgit] object extern_functions:
  import types.*

  def git_annotated_commit_free(commit: Ptr[git_annotated_commit]): Unit =
    extern

  def git_annotated_commit_from_fetchhead(
      out: Ptr[Ptr[git_annotated_commit]],
      repo: Ptr[git_repository],
      branch_name: CString,
      remote_url: CString,
      id: Ptr[git_oid]
  ): CInt = extern

  def git_annotated_commit_from_ref(
      out: Ptr[Ptr[git_annotated_commit]],
      repo: Ptr[git_repository],
      ref: Ptr[git_reference]
  ): CInt = extern

  def git_annotated_commit_from_revspec(
      out: Ptr[Ptr[git_annotated_commit]],
      repo: Ptr[git_repository],
      revspec: CString
  ): CInt = extern

  def git_annotated_commit_id(commit: Ptr[git_annotated_commit]): Ptr[git_oid] =
    extern

  def git_annotated_commit_lookup(
      out: Ptr[Ptr[git_annotated_commit]],
      repo: Ptr[git_repository],
      id: Ptr[git_oid]
  ): CInt = extern

  def git_annotated_commit_ref(commit: Ptr[git_annotated_commit]): CString =
    extern

  def git_apply(
      repo: Ptr[git_repository],
      diff: Ptr[git_diff],
      location: git_apply_location_t,
      options: Ptr[git_apply_options]
  ): CInt = extern

  def git_apply_options_init(
      opts: Ptr[git_apply_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_apply_to_tree(
      out: Ptr[Ptr[git_index]],
      repo: Ptr[git_repository],
      preimage: Ptr[git_tree],
      diff: Ptr[git_diff],
      options: Ptr[git_apply_options]
  ): CInt = extern

  def git_attr_add_macro(
      repo: Ptr[git_repository],
      name: CString,
      values: CString
  ): CInt = extern

  def git_attr_cache_flush(repo: Ptr[git_repository]): CInt = extern

  def git_attr_foreach(
      repo: Ptr[git_repository],
      flags: uint32_t,
      path: CString,
      callback: git_attr_foreach_cb,
      payload: Ptr[Byte]
  ): CInt = extern

  def git_attr_foreach_ext(
      repo: Ptr[git_repository],
      opts: Ptr[git_attr_options],
      path: CString,
      callback: git_attr_foreach_cb,
      payload: Ptr[Byte]
  ): CInt = extern

  def git_attr_get(
      value_out: Ptr[CString],
      repo: Ptr[git_repository],
      flags: uint32_t,
      path: CString,
      name: CString
  ): CInt = extern

  def git_attr_get_ext(
      value_out: Ptr[CString],
      repo: Ptr[git_repository],
      opts: Ptr[git_attr_options],
      path: CString,
      name: CString
  ): CInt = extern

  def git_attr_get_many(
      values_out: Ptr[CString],
      repo: Ptr[git_repository],
      flags: uint32_t,
      path: CString,
      num_attr: size_t,
      names: Ptr[CString]
  ): CInt = extern

  def git_attr_get_many_ext(
      values_out: Ptr[CString],
      repo: Ptr[git_repository],
      opts: Ptr[git_attr_options],
      path: CString,
      num_attr: size_t,
      names: Ptr[CString]
  ): CInt = extern

  def git_attr_value(attr: CString): git_attr_value_t = extern

  def git_blame_buffer(
      out: Ptr[Ptr[git_blame]],
      reference: Ptr[git_blame],
      buffer: CString,
      buffer_len: size_t
  ): CInt = extern

  def git_blame_file(
      out: Ptr[Ptr[git_blame]],
      repo: Ptr[git_repository],
      path: CString,
      options: Ptr[git_blame_options]
  ): CInt = extern

  def git_blame_free(blame: Ptr[git_blame]): Unit = extern

  def git_blame_get_hunk_byindex(
      blame: Ptr[git_blame],
      index: uint32_t
  ): Ptr[git_blame_hunk] = extern

  def git_blame_get_hunk_byline(
      blame: Ptr[git_blame],
      lineno: size_t
  ): Ptr[git_blame_hunk] = extern

  def git_blame_get_hunk_count(blame: Ptr[git_blame]): uint32_t = extern

  def git_blame_init_options(
      opts: Ptr[git_blame_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_blame_options_init(
      opts: Ptr[git_blame_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_blob_create_from_buffer(
      id: Ptr[git_oid],
      repo: Ptr[git_repository],
      buffer: Ptr[Byte],
      len: size_t
  ): CInt = extern

  def git_blob_create_from_disk(
      id: Ptr[git_oid],
      repo: Ptr[git_repository],
      path: CString
  ): CInt = extern

  def git_blob_create_from_stream(
      out: Ptr[Ptr[git_writestream]],
      repo: Ptr[git_repository],
      hintpath: CString
  ): CInt = extern

  def git_blob_create_from_stream_commit(
      out: Ptr[git_oid],
      stream: Ptr[git_writestream]
  ): CInt = extern

  def git_blob_create_from_workdir(
      id: Ptr[git_oid],
      repo: Ptr[git_repository],
      relative_path: CString
  ): CInt = extern

  def git_blob_create_frombuffer(
      id: Ptr[git_oid],
      repo: Ptr[git_repository],
      buffer: Ptr[Byte],
      len: size_t
  ): CInt = extern

  def git_blob_create_fromdisk(
      id: Ptr[git_oid],
      repo: Ptr[git_repository],
      path: CString
  ): CInt = extern

  def git_blob_create_fromstream(
      out: Ptr[Ptr[git_writestream]],
      repo: Ptr[git_repository],
      hintpath: CString
  ): CInt = extern

  def git_blob_create_fromstream_commit(
      out: Ptr[git_oid],
      stream: Ptr[git_writestream]
  ): CInt = extern

  def git_blob_create_fromworkdir(
      id: Ptr[git_oid],
      repo: Ptr[git_repository],
      relative_path: CString
  ): CInt = extern

  def git_blob_data_is_binary(data: CString, len: size_t): CInt = extern

  def git_blob_dup(out: Ptr[Ptr[git_blob]], source: Ptr[git_blob]): CInt =
    extern

  def git_blob_filter(
      out: Ptr[git_buf],
      blob: Ptr[git_blob],
      as_path: CString,
      opts: Ptr[git_blob_filter_options]
  ): CInt = extern

  def git_blob_filter_options_init(
      opts: Ptr[git_blob_filter_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_blob_filtered_content(
      out: Ptr[git_buf],
      blob: Ptr[git_blob],
      as_path: CString,
      check_for_binary_data: CInt
  ): CInt = extern

  def git_blob_free(blob: Ptr[git_blob]): Unit = extern

  def git_blob_id(blob: Ptr[git_blob]): Ptr[git_oid] = extern

  def git_blob_is_binary(blob: Ptr[git_blob]): CInt = extern

  def git_blob_lookup(
      blob: Ptr[Ptr[git_blob]],
      repo: Ptr[git_repository],
      id: Ptr[git_oid]
  ): CInt = extern

  def git_blob_lookup_prefix(
      blob: Ptr[Ptr[git_blob]],
      repo: Ptr[git_repository],
      id: Ptr[git_oid],
      len: size_t
  ): CInt = extern

  def git_blob_owner(blob: Ptr[git_blob]): Ptr[git_repository] = extern

  def git_blob_rawcontent(blob: Ptr[git_blob]): Ptr[Byte] = extern

  def git_blob_rawsize(blob: Ptr[git_blob]): git_object_size_t = extern

  def git_branch_create(
      out: Ptr[Ptr[git_reference]],
      repo: Ptr[git_repository],
      branch_name: CString,
      target: Ptr[git_commit],
      force: CInt
  ): CInt = extern

  def git_branch_create_from_annotated(
      ref_out: Ptr[Ptr[git_reference]],
      repository: Ptr[git_repository],
      branch_name: CString,
      commit: Ptr[git_annotated_commit],
      force: CInt
  ): CInt = extern

  def git_branch_delete(branch: Ptr[git_reference]): CInt = extern

  def git_branch_is_checked_out(branch: Ptr[git_reference]): CInt = extern

  def git_branch_is_head(branch: Ptr[git_reference]): CInt = extern

  def git_branch_iterator_free(iter: Ptr[git_branch_iterator]): Unit = extern

  def git_branch_iterator_new(
      out: Ptr[Ptr[git_branch_iterator]],
      repo: Ptr[git_repository],
      list_flags: git_branch_t
  ): CInt = extern

  def git_branch_lookup(
      out: Ptr[Ptr[git_reference]],
      repo: Ptr[git_repository],
      branch_name: CString,
      branch_type: git_branch_t
  ): CInt = extern

  def git_branch_move(
      out: Ptr[Ptr[git_reference]],
      branch: Ptr[git_reference],
      new_branch_name: CString,
      force: CInt
  ): CInt = extern

  def git_branch_name(out: Ptr[CString], ref: Ptr[git_reference]): CInt = extern

  def git_branch_name_is_valid(valid: Ptr[CInt], name: CString): CInt = extern

  def git_branch_next(
      out: Ptr[Ptr[git_reference]],
      out_type: Ptr[git_branch_t],
      iter: Ptr[git_branch_iterator]
  ): CInt = extern

  def git_branch_remote_name(
      out: Ptr[git_buf],
      repo: Ptr[git_repository],
      refname: CString
  ): CInt = extern

  def git_branch_set_upstream(
      branch: Ptr[git_reference],
      branch_name: CString
  ): CInt = extern

  def git_branch_upstream(
      out: Ptr[Ptr[git_reference]],
      branch: Ptr[git_reference]
  ): CInt = extern

  def git_branch_upstream_merge(
      buf: Ptr[git_buf],
      repo: Ptr[git_repository],
      refname: CString
  ): CInt = extern

  def git_branch_upstream_name(
      out: Ptr[git_buf],
      repo: Ptr[git_repository],
      refname: CString
  ): CInt = extern

  def git_branch_upstream_remote(
      buf: Ptr[git_buf],
      repo: Ptr[git_repository],
      refname: CString
  ): CInt = extern

  def git_buf_contains_nul(buf: Ptr[git_buf]): CInt = extern

  def git_buf_dispose(buffer: Ptr[git_buf]): Unit = extern

  def git_buf_free(buffer: Ptr[git_buf]): Unit = extern

  def git_buf_grow(buffer: Ptr[git_buf], target_size: size_t): CInt = extern

  def git_buf_is_binary(buf: Ptr[git_buf]): CInt = extern

  def git_buf_set(
      buffer: Ptr[git_buf],
      data: Ptr[Byte],
      datalen: size_t
  ): CInt = extern

  def git_checkout_head(
      repo: Ptr[git_repository],
      opts: Ptr[git_checkout_options]
  ): CInt = extern

  def git_checkout_index(
      repo: Ptr[git_repository],
      index: Ptr[git_index],
      opts: Ptr[git_checkout_options]
  ): CInt = extern

  def git_checkout_init_options(
      opts: Ptr[git_checkout_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_checkout_options_init(
      opts: Ptr[git_checkout_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_checkout_tree(
      repo: Ptr[git_repository],
      treeish: Ptr[git_object],
      opts: Ptr[git_checkout_options]
  ): CInt = extern

  def git_cherrypick(
      repo: Ptr[git_repository],
      commit: Ptr[git_commit],
      cherrypick_options: Ptr[git_cherrypick_options]
  ): CInt = extern

  def git_cherrypick_commit(
      out: Ptr[Ptr[git_index]],
      repo: Ptr[git_repository],
      cherrypick_commit: Ptr[git_commit],
      our_commit: Ptr[git_commit],
      mainline: CUnsignedInt,
      merge_options: Ptr[git_merge_options]
  ): CInt = extern

  def git_cherrypick_init_options(
      opts: Ptr[git_cherrypick_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_cherrypick_options_init(
      opts: Ptr[git_cherrypick_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_clone(
      out: Ptr[Ptr[git_repository]],
      url: CString,
      local_path: CString,
      options: Ptr[git_clone_options]
  ): CInt = extern

  def git_clone_init_options(
      opts: Ptr[git_clone_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_clone_options_init(
      opts: Ptr[git_clone_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_commit_amend(
      id: Ptr[git_oid],
      commit_to_amend: Ptr[git_commit],
      update_ref: CString,
      author: Ptr[git_signature],
      committer: Ptr[git_signature],
      message_encoding: CString,
      message: CString,
      tree: Ptr[git_tree]
  ): CInt = extern

  def git_commit_author(commit: Ptr[git_commit]): Ptr[git_signature] = extern

  def git_commit_author_with_mailmap(
      out: Ptr[Ptr[git_signature]],
      commit: Ptr[git_commit],
      mailmap: Ptr[git_mailmap]
  ): CInt = extern

  def git_commit_body(commit: Ptr[git_commit]): CString = extern

  def git_commit_committer(commit: Ptr[git_commit]): Ptr[git_signature] = extern

  def git_commit_committer_with_mailmap(
      out: Ptr[Ptr[git_signature]],
      commit: Ptr[git_commit],
      mailmap: Ptr[git_mailmap]
  ): CInt = extern

  def git_commit_create(
      id: Ptr[git_oid],
      repo: Ptr[git_repository],
      update_ref: CString,
      author: Ptr[git_signature],
      committer: Ptr[git_signature],
      message_encoding: CString,
      message: CString,
      tree: Ptr[git_tree],
      parent_count: size_t,
      parents: Unit
  ): CInt = extern

  def git_commit_create_buffer(
      out: Ptr[git_buf],
      repo: Ptr[git_repository],
      author: Ptr[git_signature],
      committer: Ptr[git_signature],
      message_encoding: CString,
      message: CString,
      tree: Ptr[git_tree],
      parent_count: size_t,
      parents: Unit
  ): CInt = extern

  def git_commit_create_v(
      id: Ptr[git_oid],
      repo: Ptr[git_repository],
      update_ref: CString,
      author: Ptr[git_signature],
      committer: Ptr[git_signature],
      message_encoding: CString,
      message: CString,
      tree: Ptr[git_tree],
      parent_count: size_t
  ): CInt = extern

  def git_commit_create_with_signature(
      out: Ptr[git_oid],
      repo: Ptr[git_repository],
      commit_content: CString,
      signature: CString,
      signature_field: CString
  ): CInt = extern

  def git_commit_dup(out: Ptr[Ptr[git_commit]], source: Ptr[git_commit]): CInt =
    extern

  def git_commit_extract_signature(
      signature: Ptr[git_buf],
      signed_data: Ptr[git_buf],
      repo: Ptr[git_repository],
      commit_id: Ptr[git_oid],
      field: CString
  ): CInt = extern

  def git_commit_free(commit: Ptr[git_commit]): Unit = extern

  def git_commit_header_field(
      out: Ptr[git_buf],
      commit: Ptr[git_commit],
      field: CString
  ): CInt = extern

  def git_commit_id(commit: Ptr[git_commit]): Ptr[git_oid] = extern

  def git_commit_lookup(
      commit: Ptr[Ptr[git_commit]],
      repo: Ptr[git_repository],
      id: Ptr[git_oid]
  ): CInt = extern

  def git_commit_lookup_prefix(
      commit: Ptr[Ptr[git_commit]],
      repo: Ptr[git_repository],
      id: Ptr[git_oid],
      len: size_t
  ): CInt = extern

  def git_commit_message(commit: Ptr[git_commit]): CString = extern

  def git_commit_message_encoding(commit: Ptr[git_commit]): CString = extern

  def git_commit_message_raw(commit: Ptr[git_commit]): CString = extern

  def git_commit_nth_gen_ancestor(
      ancestor: Ptr[Ptr[git_commit]],
      commit: Ptr[git_commit],
      n: CUnsignedInt
  ): CInt = extern

  def git_commit_owner(commit: Ptr[git_commit]): Ptr[git_repository] = extern

  def git_commit_parent(
      out: Ptr[Ptr[git_commit]],
      commit: Ptr[git_commit],
      n: CUnsignedInt
  ): CInt = extern

  def git_commit_parent_id(
      commit: Ptr[git_commit],
      n: CUnsignedInt
  ): Ptr[git_oid] = extern

  def git_commit_parentcount(commit: Ptr[git_commit]): CUnsignedInt = extern

  def git_commit_raw_header(commit: Ptr[git_commit]): CString = extern

  def git_commit_summary(commit: Ptr[git_commit]): CString = extern

  def git_commit_time(commit: Ptr[git_commit]): git_time_t = extern

  def git_commit_time_offset(commit: Ptr[git_commit]): CInt = extern

  def git_commit_tree(
      tree_out: Ptr[Ptr[git_tree]],
      commit: Ptr[git_commit]
  ): CInt = extern

  def git_commit_tree_id(commit: Ptr[git_commit]): Ptr[git_oid] = extern

  def git_config_add_file_ondisk(
      cfg: Ptr[git_config],
      path: CString,
      level: git_config_level_t,
      repo: Ptr[git_repository],
      force: CInt
  ): CInt = extern

  def git_config_backend_foreach_match(
      backend: Ptr[git_config_backend],
      regexp: CString,
      callback: git_config_foreach_cb,
      payload: Ptr[Byte]
  ): CInt = extern

  def git_config_delete_entry(cfg: Ptr[git_config], name: CString): CInt =
    extern

  def git_config_delete_multivar(
      cfg: Ptr[git_config],
      name: CString,
      regexp: CString
  ): CInt = extern

  def git_config_entry_free(entry: Ptr[git_config_entry]): Unit = extern

  def git_config_find_global(out: Ptr[git_buf]): CInt = extern

  def git_config_find_programdata(out: Ptr[git_buf]): CInt = extern

  def git_config_find_system(out: Ptr[git_buf]): CInt = extern

  def git_config_find_xdg(out: Ptr[git_buf]): CInt = extern

  def git_config_foreach(
      cfg: Ptr[git_config],
      callback: git_config_foreach_cb,
      payload: Ptr[Byte]
  ): CInt = extern

  def git_config_foreach_match(
      cfg: Ptr[git_config],
      regexp: CString,
      callback: git_config_foreach_cb,
      payload: Ptr[Byte]
  ): CInt = extern

  def git_config_free(cfg: Ptr[git_config]): Unit = extern

  def git_config_get_bool(
      out: Ptr[CInt],
      cfg: Ptr[git_config],
      name: CString
  ): CInt = extern

  def git_config_get_entry(
      out: Ptr[Ptr[git_config_entry]],
      cfg: Ptr[git_config],
      name: CString
  ): CInt = extern

  def git_config_get_int32(
      out: Ptr[int32_t],
      cfg: Ptr[git_config],
      name: CString
  ): CInt = extern

  def git_config_get_int64(
      out: Ptr[int64_t],
      cfg: Ptr[git_config],
      name: CString
  ): CInt = extern

  def git_config_get_mapped(
      out: Ptr[CInt],
      cfg: Ptr[git_config],
      name: CString,
      maps: Ptr[git_configmap],
      map_n: size_t
  ): CInt = extern

  def git_config_get_multivar_foreach(
      cfg: Ptr[git_config],
      name: CString,
      regexp: CString,
      callback: git_config_foreach_cb,
      payload: Ptr[Byte]
  ): CInt = extern

  def git_config_get_path(
      out: Ptr[git_buf],
      cfg: Ptr[git_config],
      name: CString
  ): CInt = extern

  def git_config_get_string(
      out: Ptr[CString],
      cfg: Ptr[git_config],
      name: CString
  ): CInt = extern

  def git_config_get_string_buf(
      out: Ptr[git_buf],
      cfg: Ptr[git_config],
      name: CString
  ): CInt = extern

  def git_config_iterator_free(iter: Ptr[git_config_iterator]): Unit = extern

  def git_config_iterator_glob_new(
      out: Ptr[Ptr[git_config_iterator]],
      cfg: Ptr[git_config],
      regexp: CString
  ): CInt = extern

  def git_config_iterator_new(
      out: Ptr[Ptr[git_config_iterator]],
      cfg: Ptr[git_config]
  ): CInt = extern

  def git_config_lock(
      tx: Ptr[Ptr[git_transaction]],
      cfg: Ptr[git_config]
  ): CInt = extern

  def git_config_lookup_map_value(
      out: Ptr[CInt],
      maps: Ptr[git_configmap],
      map_n: size_t,
      value: CString
  ): CInt = extern

  def git_config_multivar_iterator_new(
      out: Ptr[Ptr[git_config_iterator]],
      cfg: Ptr[git_config],
      name: CString,
      regexp: CString
  ): CInt = extern

  def git_config_new(out: Ptr[Ptr[git_config]]): CInt = extern

  def git_config_next(
      entry: Ptr[Ptr[git_config_entry]],
      iter: Ptr[git_config_iterator]
  ): CInt = extern

  def git_config_open_default(out: Ptr[Ptr[git_config]]): CInt = extern

  def git_config_open_global(
      out: Ptr[Ptr[git_config]],
      config: Ptr[git_config]
  ): CInt = extern

  def git_config_open_level(
      out: Ptr[Ptr[git_config]],
      parent: Ptr[git_config],
      level: git_config_level_t
  ): CInt = extern

  def git_config_open_ondisk(out: Ptr[Ptr[git_config]], path: CString): CInt =
    extern

  def git_config_parse_bool(out: Ptr[CInt], value: CString): CInt = extern

  def git_config_parse_int32(out: Ptr[int32_t], value: CString): CInt = extern

  def git_config_parse_int64(out: Ptr[int64_t], value: CString): CInt = extern

  def git_config_parse_path(out: Ptr[git_buf], value: CString): CInt = extern

  def git_config_set_bool(
      cfg: Ptr[git_config],
      name: CString,
      value: CInt
  ): CInt = extern

  def git_config_set_int32(
      cfg: Ptr[git_config],
      name: CString,
      value: int32_t
  ): CInt = extern

  def git_config_set_int64(
      cfg: Ptr[git_config],
      name: CString,
      value: int64_t
  ): CInt = extern

  def git_config_set_multivar(
      cfg: Ptr[git_config],
      name: CString,
      regexp: CString,
      value: CString
  ): CInt = extern

  def git_config_set_string(
      cfg: Ptr[git_config],
      name: CString,
      value: CString
  ): CInt = extern

  def git_config_snapshot(
      out: Ptr[Ptr[git_config]],
      config: Ptr[git_config]
  ): CInt = extern

  def git_cred_default_new(out: Ptr[Ptr[git_credential]]): CInt = extern

  def git_cred_free(cred: Ptr[git_credential]): Unit = extern

  def git_cred_get_username(cred: Ptr[git_credential]): CString = extern

  def git_cred_has_username(cred: Ptr[git_credential]): CInt = extern

  def git_cred_ssh_custom_new(
      out: Ptr[Ptr[git_credential]],
      username: CString,
      publickey: CString,
      publickey_len: size_t,
      sign_callback: git_credential_sign_cb,
      payload: Ptr[Byte]
  ): CInt = extern

  def git_cred_ssh_interactive_new(
      out: Ptr[Ptr[git_credential]],
      username: CString,
      prompt_callback: git_credential_ssh_interactive_cb,
      payload: Ptr[Byte]
  ): CInt = extern

  def git_cred_ssh_key_from_agent(
      out: Ptr[Ptr[git_credential]],
      username: CString
  ): CInt = extern

  def git_cred_ssh_key_memory_new(
      out: Ptr[Ptr[git_credential]],
      username: CString,
      publickey: CString,
      privatekey: CString,
      passphrase: CString
  ): CInt = extern

  def git_cred_ssh_key_new(
      out: Ptr[Ptr[git_credential]],
      username: CString,
      publickey: CString,
      privatekey: CString,
      passphrase: CString
  ): CInt = extern

  def git_cred_username_new(
      out: Ptr[Ptr[git_credential]],
      username: CString
  ): CInt = extern

  def git_cred_userpass(
      out: Ptr[Ptr[git_credential]],
      url: CString,
      user_from_url: CString,
      allowed_types: CUnsignedInt,
      payload: Ptr[Byte]
  ): CInt = extern

  def git_cred_userpass_plaintext_new(
      out: Ptr[Ptr[git_credential]],
      username: CString,
      password: CString
  ): CInt = extern

  def git_credential_default_new(out: Ptr[Ptr[git_credential]]): CInt = extern

  def git_credential_free(cred: Ptr[git_credential]): Unit = extern

  def git_credential_get_username(cred: Ptr[git_credential]): CString = extern

  def git_credential_has_username(cred: Ptr[git_credential]): CInt = extern

  def git_credential_ssh_custom_new(
      out: Ptr[Ptr[git_credential]],
      username: CString,
      publickey: CString,
      publickey_len: size_t,
      sign_callback: git_credential_sign_cb,
      payload: Ptr[Byte]
  ): CInt = extern

  def git_credential_ssh_interactive_new(
      out: Ptr[Ptr[git_credential]],
      username: CString,
      prompt_callback: git_credential_ssh_interactive_cb,
      payload: Ptr[Byte]
  ): CInt = extern

  def git_credential_ssh_key_from_agent(
      out: Ptr[Ptr[git_credential]],
      username: CString
  ): CInt = extern

  def git_credential_ssh_key_memory_new(
      out: Ptr[Ptr[git_credential]],
      username: CString,
      publickey: CString,
      privatekey: CString,
      passphrase: CString
  ): CInt = extern

  def git_credential_ssh_key_new(
      out: Ptr[Ptr[git_credential]],
      username: CString,
      publickey: CString,
      privatekey: CString,
      passphrase: CString
  ): CInt = extern

  def git_credential_username_new(
      out: Ptr[Ptr[git_credential]],
      username: CString
  ): CInt = extern

  def git_credential_userpass(
      out: Ptr[Ptr[git_credential]],
      url: CString,
      user_from_url: CString,
      allowed_types: CUnsignedInt,
      payload: Ptr[Byte]
  ): CInt = extern

  def git_credential_userpass_plaintext_new(
      out: Ptr[Ptr[git_credential]],
      username: CString,
      password: CString
  ): CInt = extern

  def git_describe_commit(
      result: Ptr[Ptr[git_describe_result]],
      committish: Ptr[git_object],
      opts: Ptr[git_describe_options]
  ): CInt = extern

  def git_describe_format(
      out: Ptr[git_buf],
      result: Ptr[git_describe_result],
      opts: Ptr[git_describe_format_options]
  ): CInt = extern

  def git_describe_format_options_init(
      opts: Ptr[git_describe_format_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_describe_init_format_options(
      opts: Ptr[git_describe_format_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_describe_init_options(
      opts: Ptr[git_describe_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_describe_options_init(
      opts: Ptr[git_describe_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_describe_result_free(result: Ptr[git_describe_result]): Unit = extern

  def git_describe_workdir(
      out: Ptr[Ptr[git_describe_result]],
      repo: Ptr[git_repository],
      opts: Ptr[git_describe_options]
  ): CInt = extern

  def git_diff_blob_to_buffer(
      old_blob: Ptr[git_blob],
      old_as_path: CString,
      buffer: CString,
      buffer_len: size_t,
      buffer_as_path: CString,
      options: Ptr[git_diff_options],
      file_cb: git_diff_file_cb,
      binary_cb: git_diff_binary_cb,
      hunk_cb: git_diff_hunk_cb,
      line_cb: git_diff_line_cb,
      payload: Ptr[Byte]
  ): CInt = extern

  def git_diff_blobs(
      old_blob: Ptr[git_blob],
      old_as_path: CString,
      new_blob: Ptr[git_blob],
      new_as_path: CString,
      options: Ptr[git_diff_options],
      file_cb: git_diff_file_cb,
      binary_cb: git_diff_binary_cb,
      hunk_cb: git_diff_hunk_cb,
      line_cb: git_diff_line_cb,
      payload: Ptr[Byte]
  ): CInt = extern

  def git_diff_buffers(
      old_buffer: Ptr[Byte],
      old_len: size_t,
      old_as_path: CString,
      new_buffer: Ptr[Byte],
      new_len: size_t,
      new_as_path: CString,
      options: Ptr[git_diff_options],
      file_cb: git_diff_file_cb,
      binary_cb: git_diff_binary_cb,
      hunk_cb: git_diff_hunk_cb,
      line_cb: git_diff_line_cb,
      payload: Ptr[Byte]
  ): CInt = extern

  def git_diff_commit_as_email(
      out: Ptr[git_buf],
      repo: Ptr[git_repository],
      commit: Ptr[git_commit],
      patch_no: size_t,
      total_patches: size_t,
      flags: uint32_t,
      diff_opts: Ptr[git_diff_options]
  ): CInt = extern

  def git_diff_find_init_options(
      opts: Ptr[git_diff_find_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_diff_find_options_init(
      opts: Ptr[git_diff_find_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_diff_find_similar(
      diff: Ptr[git_diff],
      options: Ptr[git_diff_find_options]
  ): CInt = extern

  def git_diff_foreach(
      diff: Ptr[git_diff],
      file_cb: git_diff_file_cb,
      binary_cb: git_diff_binary_cb,
      hunk_cb: git_diff_hunk_cb,
      line_cb: git_diff_line_cb,
      payload: Ptr[Byte]
  ): CInt = extern

  def git_diff_format_email(
      out: Ptr[git_buf],
      diff: Ptr[git_diff],
      opts: Ptr[git_diff_format_email_options]
  ): CInt = extern

  def git_diff_format_email_init_options(
      opts: Ptr[git_diff_format_email_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_diff_format_email_options_init(
      opts: Ptr[git_diff_format_email_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_diff_free(diff: Ptr[git_diff]): Unit = extern

  def git_diff_from_buffer(
      out: Ptr[Ptr[git_diff]],
      content: CString,
      content_len: size_t
  ): CInt = extern

  def git_diff_get_delta(
      diff: Ptr[git_diff],
      idx: size_t
  ): Ptr[git_diff_delta] = extern

  def git_diff_get_stats(
      out: Ptr[Ptr[git_diff_stats]],
      diff: Ptr[git_diff]
  ): CInt = extern

  def git_diff_index_to_index(
      diff: Ptr[Ptr[git_diff]],
      repo: Ptr[git_repository],
      old_index: Ptr[git_index],
      new_index: Ptr[git_index],
      opts: Ptr[git_diff_options]
  ): CInt = extern

  def git_diff_index_to_workdir(
      diff: Ptr[Ptr[git_diff]],
      repo: Ptr[git_repository],
      index: Ptr[git_index],
      opts: Ptr[git_diff_options]
  ): CInt = extern

  def git_diff_init_options(
      opts: Ptr[git_diff_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_diff_is_sorted_icase(diff: Ptr[git_diff]): CInt = extern

  def git_diff_merge(onto: Ptr[git_diff], from: Ptr[git_diff]): CInt = extern

  def git_diff_num_deltas(diff: Ptr[git_diff]): size_t = extern

  def git_diff_num_deltas_of_type(
      diff: Ptr[git_diff],
      `type`: git_delta_t
  ): size_t = extern

  def git_diff_options_init(
      opts: Ptr[git_diff_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_diff_patchid(
      out: Ptr[git_oid],
      diff: Ptr[git_diff],
      opts: Ptr[git_diff_patchid_options]
  ): CInt = extern

  def git_diff_patchid_init_options(
      opts: Ptr[git_diff_patchid_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_diff_patchid_options_init(
      opts: Ptr[git_diff_patchid_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_diff_print(
      diff: Ptr[git_diff],
      format: git_diff_format_t,
      print_cb: git_diff_line_cb,
      payload: Ptr[Byte]
  ): CInt = extern

  def git_diff_stats_deletions(stats: Ptr[git_diff_stats]): size_t = extern

  def git_diff_stats_files_changed(stats: Ptr[git_diff_stats]): size_t = extern

  def git_diff_stats_free(stats: Ptr[git_diff_stats]): Unit = extern

  def git_diff_stats_insertions(stats: Ptr[git_diff_stats]): size_t = extern

  def git_diff_stats_to_buf(
      out: Ptr[git_buf],
      stats: Ptr[git_diff_stats],
      format: git_diff_stats_format_t,
      width: size_t
  ): CInt = extern

  def git_diff_status_char(status: git_delta_t): CChar = extern

  def git_diff_to_buf(
      out: Ptr[git_buf],
      diff: Ptr[git_diff],
      format: git_diff_format_t
  ): CInt = extern

  def git_diff_tree_to_index(
      diff: Ptr[Ptr[git_diff]],
      repo: Ptr[git_repository],
      old_tree: Ptr[git_tree],
      index: Ptr[git_index],
      opts: Ptr[git_diff_options]
  ): CInt = extern

  def git_diff_tree_to_tree(
      diff: Ptr[Ptr[git_diff]],
      repo: Ptr[git_repository],
      old_tree: Ptr[git_tree],
      new_tree: Ptr[git_tree],
      opts: Ptr[git_diff_options]
  ): CInt = extern

  def git_diff_tree_to_workdir(
      diff: Ptr[Ptr[git_diff]],
      repo: Ptr[git_repository],
      old_tree: Ptr[git_tree],
      opts: Ptr[git_diff_options]
  ): CInt = extern

  def git_diff_tree_to_workdir_with_index(
      diff: Ptr[Ptr[git_diff]],
      repo: Ptr[git_repository],
      old_tree: Ptr[git_tree],
      opts: Ptr[git_diff_options]
  ): CInt = extern

  def git_email_create_from_commit(
      out: Ptr[git_buf],
      commit: Ptr[git_commit],
      opts: Ptr[git_email_create_options]
  ): CInt = extern

  def git_email_create_from_diff(
      out: Ptr[git_buf],
      diff: Ptr[git_diff],
      patch_idx: size_t,
      patch_count: size_t,
      commit_id: Ptr[git_oid],
      summary: CString,
      body: CString,
      author: Ptr[git_signature],
      opts: Ptr[git_email_create_options]
  ): CInt = extern

  def git_error_clear(): Unit = extern

  def git_error_last(): Ptr[git_error] = extern

  def git_error_set_oom(): Unit = extern

  def git_error_set_str(error_class: CInt, string: CString): CInt = extern

  def git_fetch_init_options(
      opts: Ptr[git_fetch_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_fetch_options_init(
      opts: Ptr[git_fetch_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_filter_list_apply_to_blob(
      out: Ptr[git_buf],
      filters: Ptr[git_filter_list],
      blob: Ptr[git_blob]
  ): CInt = extern

  def git_filter_list_apply_to_buffer(
      out: Ptr[git_buf],
      filters: Ptr[git_filter_list],
      in: CString,
      in_len: size_t
  ): CInt = extern

  def git_filter_list_apply_to_data(
      out: Ptr[git_buf],
      filters: Ptr[git_filter_list],
      in: Ptr[git_buf]
  ): CInt = extern

  def git_filter_list_apply_to_file(
      out: Ptr[git_buf],
      filters: Ptr[git_filter_list],
      repo: Ptr[git_repository],
      path: CString
  ): CInt = extern

  def git_filter_list_contains(
      filters: Ptr[git_filter_list],
      name: CString
  ): CInt = extern

  def git_filter_list_free(filters: Ptr[git_filter_list]): Unit = extern

  def git_filter_list_load(
      filters: Ptr[Ptr[git_filter_list]],
      repo: Ptr[git_repository],
      blob: Ptr[git_blob],
      path: CString,
      mode: git_filter_mode_t,
      flags: uint32_t
  ): CInt = extern

  def git_filter_list_load_ext(
      filters: Ptr[Ptr[git_filter_list]],
      repo: Ptr[git_repository],
      blob: Ptr[git_blob],
      path: CString,
      mode: git_filter_mode_t,
      opts: Ptr[git_filter_options]
  ): CInt = extern

  def git_filter_list_stream_blob(
      filters: Ptr[git_filter_list],
      blob: Ptr[git_blob],
      target: Ptr[git_writestream]
  ): CInt = extern

  def git_filter_list_stream_buffer(
      filters: Ptr[git_filter_list],
      buffer: CString,
      len: size_t,
      target: Ptr[git_writestream]
  ): CInt = extern

  def git_filter_list_stream_data(
      filters: Ptr[git_filter_list],
      data: Ptr[git_buf],
      target: Ptr[git_writestream]
  ): CInt = extern

  def git_filter_list_stream_file(
      filters: Ptr[git_filter_list],
      repo: Ptr[git_repository],
      path: CString,
      target: Ptr[git_writestream]
  ): CInt = extern

  def git_graph_ahead_behind(
      ahead: Ptr[size_t],
      behind: Ptr[size_t],
      repo: Ptr[git_repository],
      local: Ptr[git_oid],
      upstream: Ptr[git_oid]
  ): CInt = extern

  def git_graph_descendant_of(
      repo: Ptr[git_repository],
      commit: Ptr[git_oid],
      ancestor: Ptr[git_oid]
  ): CInt = extern

  def git_graph_reachable_from_any(
      repo: Ptr[git_repository],
      commit: Ptr[git_oid],
      descendant_array: Unit,
      length: size_t
  ): CInt = extern

  def git_ignore_add_rule(repo: Ptr[git_repository], rules: CString): CInt =
    extern

  def git_ignore_clear_internal_rules(repo: Ptr[git_repository]): CInt = extern

  def git_ignore_path_is_ignored(
      ignored: Ptr[CInt],
      repo: Ptr[git_repository],
      path: CString
  ): CInt = extern

  def git_index_add(
      index: Ptr[git_index],
      source_entry: Ptr[git_index_entry]
  ): CInt = extern

  def git_index_add_all(
      index: Ptr[git_index],
      pathspec: Ptr[git_strarray],
      flags: CUnsignedInt,
      callback: git_index_matched_path_cb,
      payload: Ptr[Byte]
  ): CInt = extern

  def git_index_add_bypath(index: Ptr[git_index], path: CString): CInt = extern

  def git_index_add_from_buffer(
      index: Ptr[git_index],
      entry: Ptr[git_index_entry],
      buffer: Ptr[Byte],
      len: size_t
  ): CInt = extern

  def git_index_add_frombuffer(
      index: Ptr[git_index],
      entry: Ptr[git_index_entry],
      buffer: Ptr[Byte],
      len: size_t
  ): CInt = extern

  def git_index_caps(index: Ptr[git_index]): CInt = extern

  def git_index_checksum(index: Ptr[git_index]): Ptr[git_oid] = extern

  def git_index_clear(index: Ptr[git_index]): CInt = extern

  def git_index_conflict_add(
      index: Ptr[git_index],
      ancestor_entry: Ptr[git_index_entry],
      our_entry: Ptr[git_index_entry],
      their_entry: Ptr[git_index_entry]
  ): CInt = extern

  def git_index_conflict_cleanup(index: Ptr[git_index]): CInt = extern

  def git_index_conflict_get(
      ancestor_out: Ptr[Ptr[git_index_entry]],
      our_out: Ptr[Ptr[git_index_entry]],
      their_out: Ptr[Ptr[git_index_entry]],
      index: Ptr[git_index],
      path: CString
  ): CInt = extern

  def git_index_conflict_iterator_free(
      iterator: Ptr[git_index_conflict_iterator]
  ): Unit = extern

  def git_index_conflict_iterator_new(
      iterator_out: Ptr[Ptr[git_index_conflict_iterator]],
      index: Ptr[git_index]
  ): CInt = extern

  def git_index_conflict_next(
      ancestor_out: Ptr[Ptr[git_index_entry]],
      our_out: Ptr[Ptr[git_index_entry]],
      their_out: Ptr[Ptr[git_index_entry]],
      iterator: Ptr[git_index_conflict_iterator]
  ): CInt = extern

  def git_index_conflict_remove(index: Ptr[git_index], path: CString): CInt =
    extern

  def git_index_entry_is_conflict(entry: Ptr[git_index_entry]): CInt = extern

  def git_index_entry_stage(entry: Ptr[git_index_entry]): CInt = extern

  def git_index_entrycount(index: Ptr[git_index]): size_t = extern

  def git_index_find(
      at_pos: Ptr[size_t],
      index: Ptr[git_index],
      path: CString
  ): CInt = extern

  def git_index_find_prefix(
      at_pos: Ptr[size_t],
      index: Ptr[git_index],
      prefix: CString
  ): CInt = extern

  def git_index_free(index: Ptr[git_index]): Unit = extern

  def git_index_get_byindex(
      index: Ptr[git_index],
      n: size_t
  ): Ptr[git_index_entry] = extern

  def git_index_get_bypath(
      index: Ptr[git_index],
      path: CString,
      stage: CInt
  ): Ptr[git_index_entry] = extern

  def git_index_has_conflicts(index: Ptr[git_index]): CInt = extern

  def git_index_iterator_free(iterator: Ptr[git_index_iterator]): Unit = extern

  def git_index_iterator_new(
      iterator_out: Ptr[Ptr[git_index_iterator]],
      index: Ptr[git_index]
  ): CInt = extern

  def git_index_iterator_next(
      out: Ptr[Ptr[git_index_entry]],
      iterator: Ptr[git_index_iterator]
  ): CInt = extern

  def git_index_new(out: Ptr[Ptr[git_index]]): CInt = extern

  def git_index_open(out: Ptr[Ptr[git_index]], index_path: CString): CInt =
    extern

  def git_index_owner(index: Ptr[git_index]): Ptr[git_repository] = extern

  def git_index_path(index: Ptr[git_index]): CString = extern

  def git_index_read(index: Ptr[git_index], force: CInt): CInt = extern

  def git_index_read_tree(index: Ptr[git_index], tree: Ptr[git_tree]): CInt =
    extern

  def git_index_remove(
      index: Ptr[git_index],
      path: CString,
      stage: CInt
  ): CInt = extern

  def git_index_remove_all(
      index: Ptr[git_index],
      pathspec: Ptr[git_strarray],
      callback: git_index_matched_path_cb,
      payload: Ptr[Byte]
  ): CInt = extern

  def git_index_remove_bypath(index: Ptr[git_index], path: CString): CInt =
    extern

  def git_index_remove_directory(
      index: Ptr[git_index],
      dir: CString,
      stage: CInt
  ): CInt = extern

  def git_index_set_caps(index: Ptr[git_index], caps: CInt): CInt = extern

  def git_index_set_version(
      index: Ptr[git_index],
      version: CUnsignedInt
  ): CInt = extern

  def git_index_update_all(
      index: Ptr[git_index],
      pathspec: Ptr[git_strarray],
      callback: git_index_matched_path_cb,
      payload: Ptr[Byte]
  ): CInt = extern

  def git_index_version(index: Ptr[git_index]): CUnsignedInt = extern

  def git_index_write(index: Ptr[git_index]): CInt = extern

  def git_index_write_tree(out: Ptr[git_oid], index: Ptr[git_index]): CInt =
    extern

  def git_index_write_tree_to(
      out: Ptr[git_oid],
      index: Ptr[git_index],
      repo: Ptr[git_repository]
  ): CInt = extern

  def git_indexer_append(
      idx: Ptr[git_indexer],
      data: Ptr[Byte],
      size: size_t,
      stats: Ptr[git_indexer_progress]
  ): CInt = extern

  def git_indexer_commit(
      idx: Ptr[git_indexer],
      stats: Ptr[git_indexer_progress]
  ): CInt = extern

  def git_indexer_free(idx: Ptr[git_indexer]): Unit = extern

  def git_indexer_hash(idx: Ptr[git_indexer]): Ptr[git_oid] = extern

  def git_indexer_init_options(
      opts: Ptr[git_indexer_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_indexer_name(idx: Ptr[git_indexer]): CString = extern

  def git_indexer_new(
      out: Ptr[Ptr[git_indexer]],
      path: CString,
      mode: CUnsignedInt,
      odb: Ptr[git_odb],
      opts: Ptr[git_indexer_options]
  ): CInt = extern

  def git_indexer_options_init(
      opts: Ptr[git_indexer_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_libgit2_features(): CInt = extern

  def git_libgit2_init(): CInt = extern

  def git_libgit2_opts(option: CInt): CInt = extern

  def git_libgit2_shutdown(): CInt = extern

  def git_libgit2_version(
      major: Ptr[CInt],
      minor: Ptr[CInt],
      rev: Ptr[CInt]
  ): CInt = extern

  def git_mailmap_add_entry(
      mm: Ptr[git_mailmap],
      real_name: CString,
      real_email: CString,
      replace_name: CString,
      replace_email: CString
  ): CInt = extern

  def git_mailmap_free(mm: Ptr[git_mailmap]): Unit = extern

  def git_mailmap_from_buffer(
      out: Ptr[Ptr[git_mailmap]],
      buf: CString,
      len: size_t
  ): CInt = extern

  def git_mailmap_from_repository(
      out: Ptr[Ptr[git_mailmap]],
      repo: Ptr[git_repository]
  ): CInt = extern

  def git_mailmap_new(out: Ptr[Ptr[git_mailmap]]): CInt = extern

  def git_mailmap_resolve(
      real_name: Ptr[CString],
      real_email: Ptr[CString],
      mm: Ptr[git_mailmap],
      name: CString,
      email: CString
  ): CInt = extern

  def git_mailmap_resolve_signature(
      out: Ptr[Ptr[git_signature]],
      mm: Ptr[git_mailmap],
      sig: Ptr[git_signature]
  ): CInt = extern

  def git_merge(
      repo: Ptr[git_repository],
      their_heads: Ptr[Ptr[git_annotated_commit]],
      their_heads_len: size_t,
      merge_opts: Ptr[git_merge_options],
      checkout_opts: Ptr[git_checkout_options]
  ): CInt = extern

  def git_merge_analysis(
      analysis_out: Ptr[git_merge_analysis_t],
      preference_out: Ptr[git_merge_preference_t],
      repo: Ptr[git_repository],
      their_heads: Ptr[Ptr[git_annotated_commit]],
      their_heads_len: size_t
  ): CInt = extern

  def git_merge_analysis_for_ref(
      analysis_out: Ptr[git_merge_analysis_t],
      preference_out: Ptr[git_merge_preference_t],
      repo: Ptr[git_repository],
      our_ref: Ptr[git_reference],
      their_heads: Ptr[Ptr[git_annotated_commit]],
      their_heads_len: size_t
  ): CInt = extern

  def git_merge_base(
      out: Ptr[git_oid],
      repo: Ptr[git_repository],
      one: Ptr[git_oid],
      two: Ptr[git_oid]
  ): CInt = extern

  def git_merge_base_many(
      out: Ptr[git_oid],
      repo: Ptr[git_repository],
      length: size_t,
      input_array: Unit
  ): CInt = extern

  def git_merge_base_octopus(
      out: Ptr[git_oid],
      repo: Ptr[git_repository],
      length: size_t,
      input_array: Unit
  ): CInt = extern

  def git_merge_bases(
      out: Ptr[git_oidarray],
      repo: Ptr[git_repository],
      one: Ptr[git_oid],
      two: Ptr[git_oid]
  ): CInt = extern

  def git_merge_bases_many(
      out: Ptr[git_oidarray],
      repo: Ptr[git_repository],
      length: size_t,
      input_array: Unit
  ): CInt = extern

  def git_merge_commits(
      out: Ptr[Ptr[git_index]],
      repo: Ptr[git_repository],
      our_commit: Ptr[git_commit],
      their_commit: Ptr[git_commit],
      opts: Ptr[git_merge_options]
  ): CInt = extern

  def git_merge_file(
      out: Ptr[git_merge_file_result],
      ancestor: Ptr[git_merge_file_input],
      ours: Ptr[git_merge_file_input],
      theirs: Ptr[git_merge_file_input],
      opts: Ptr[git_merge_file_options]
  ): CInt = extern

  def git_merge_file_from_index(
      out: Ptr[git_merge_file_result],
      repo: Ptr[git_repository],
      ancestor: Ptr[git_index_entry],
      ours: Ptr[git_index_entry],
      theirs: Ptr[git_index_entry],
      opts: Ptr[git_merge_file_options]
  ): CInt = extern

  def git_merge_file_init_input(
      input: Ptr[git_merge_file_input],
      version: CUnsignedInt
  ): CInt = extern

  def git_merge_file_init_options(
      opts: Ptr[git_merge_file_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_merge_file_input_init(
      opts: Ptr[git_merge_file_input],
      version: CUnsignedInt
  ): CInt = extern

  def git_merge_file_options_init(
      opts: Ptr[git_merge_file_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_merge_file_result_free(result: Ptr[git_merge_file_result]): Unit =
    extern

  def git_merge_init_options(
      opts: Ptr[git_merge_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_merge_options_init(
      opts: Ptr[git_merge_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_merge_trees(
      out: Ptr[Ptr[git_index]],
      repo: Ptr[git_repository],
      ancestor_tree: Ptr[git_tree],
      our_tree: Ptr[git_tree],
      their_tree: Ptr[git_tree],
      opts: Ptr[git_merge_options]
  ): CInt = extern

  def git_message_prettify(
      out: Ptr[git_buf],
      message: CString,
      strip_comments: CInt,
      comment_char: CChar
  ): CInt = extern

  def git_message_trailer_array_free(
      arr: Ptr[git_message_trailer_array]
  ): Unit = extern

  def git_message_trailers(
      arr: Ptr[git_message_trailer_array],
      message: CString
  ): CInt = extern

  def git_note_author(note: Ptr[git_note]): Ptr[git_signature] = extern

  def git_note_commit_create(
      notes_commit_out: Ptr[git_oid],
      notes_blob_out: Ptr[git_oid],
      repo: Ptr[git_repository],
      parent: Ptr[git_commit],
      author: Ptr[git_signature],
      committer: Ptr[git_signature],
      oid: Ptr[git_oid],
      note: CString,
      allow_note_overwrite: CInt
  ): CInt = extern

  def git_note_commit_iterator_new(
      out: Ptr[Ptr[git_note_iterator]],
      notes_commit: Ptr[git_commit]
  ): CInt = extern

  def git_note_commit_read(
      out: Ptr[Ptr[git_note]],
      repo: Ptr[git_repository],
      notes_commit: Ptr[git_commit],
      oid: Ptr[git_oid]
  ): CInt = extern

  def git_note_commit_remove(
      notes_commit_out: Ptr[git_oid],
      repo: Ptr[git_repository],
      notes_commit: Ptr[git_commit],
      author: Ptr[git_signature],
      committer: Ptr[git_signature],
      oid: Ptr[git_oid]
  ): CInt = extern

  def git_note_committer(note: Ptr[git_note]): Ptr[git_signature] = extern

  def git_note_create(
      out: Ptr[git_oid],
      repo: Ptr[git_repository],
      notes_ref: CString,
      author: Ptr[git_signature],
      committer: Ptr[git_signature],
      oid: Ptr[git_oid],
      note: CString,
      force: CInt
  ): CInt = extern

  def git_note_default_ref(out: Ptr[git_buf], repo: Ptr[git_repository]): CInt =
    extern

  def git_note_foreach(
      repo: Ptr[git_repository],
      notes_ref: CString,
      note_cb: git_note_foreach_cb,
      payload: Ptr[Byte]
  ): CInt = extern

  def git_note_free(note: Ptr[git_note]): Unit = extern

  def git_note_id(note: Ptr[git_note]): Ptr[git_oid] = extern

  def git_note_iterator_free(it: Ptr[git_note_iterator]): Unit = extern

  def git_note_iterator_new(
      out: Ptr[Ptr[git_note_iterator]],
      repo: Ptr[git_repository],
      notes_ref: CString
  ): CInt = extern

  def git_note_message(note: Ptr[git_note]): CString = extern

  def git_note_next(
      note_id: Ptr[git_oid],
      annotated_id: Ptr[git_oid],
      it: Ptr[git_note_iterator]
  ): CInt = extern

  def git_note_read(
      out: Ptr[Ptr[git_note]],
      repo: Ptr[git_repository],
      notes_ref: CString,
      oid: Ptr[git_oid]
  ): CInt = extern

  def git_note_remove(
      repo: Ptr[git_repository],
      notes_ref: CString,
      author: Ptr[git_signature],
      committer: Ptr[git_signature],
      oid: Ptr[git_oid]
  ): CInt = extern

  def git_object__size(`type`: git_object_t): size_t = extern

  def git_object_dup(
      dest: Ptr[Ptr[git_object]],
      source: Ptr[git_object]
  ): CInt = extern

  def git_object_free(`object`: Ptr[git_object]): Unit = extern

  def git_object_id(obj: Ptr[git_object]): Ptr[git_oid] = extern

  def git_object_lookup(
      `object`: Ptr[Ptr[git_object]],
      repo: Ptr[git_repository],
      id: Ptr[git_oid],
      `type`: git_object_t
  ): CInt = extern

  def git_object_lookup_bypath(
      out: Ptr[Ptr[git_object]],
      treeish: Ptr[git_object],
      path: CString,
      `type`: git_object_t
  ): CInt = extern

  def git_object_lookup_prefix(
      object_out: Ptr[Ptr[git_object]],
      repo: Ptr[git_repository],
      id: Ptr[git_oid],
      len: size_t,
      `type`: git_object_t
  ): CInt = extern

  def git_object_owner(obj: Ptr[git_object]): Ptr[git_repository] = extern

  def git_object_peel(
      peeled: Ptr[Ptr[git_object]],
      `object`: Ptr[git_object],
      target_type: git_object_t
  ): CInt = extern

  def git_object_rawcontent_is_valid(
      valid: Ptr[CInt],
      buf: CString,
      len: size_t,
      `type`: git_object_t
  ): CInt = extern

  def git_object_short_id(out: Ptr[git_buf], obj: Ptr[git_object]): CInt =
    extern

  def git_object_string2type(str: CString): git_object_t = extern

  def git_object_type(obj: Ptr[git_object]): git_object_t = extern

  def git_object_type2string(`type`: git_object_t): CString = extern

  def git_object_typeisloose(`type`: git_object_t): CInt = extern

  def git_odb_add_alternate(
      odb: Ptr[git_odb],
      backend: Ptr[git_odb_backend],
      priority: CInt
  ): CInt = extern

  def git_odb_add_backend(
      odb: Ptr[git_odb],
      backend: Ptr[git_odb_backend],
      priority: CInt
  ): CInt = extern

  def git_odb_add_disk_alternate(odb: Ptr[git_odb], path: CString): CInt =
    extern

  def git_odb_backend_loose(
      out: Ptr[Ptr[git_odb_backend]],
      objects_dir: CString,
      compression_level: CInt,
      do_fsync: CInt,
      dir_mode: CUnsignedInt,
      file_mode: CUnsignedInt
  ): CInt = extern

  def git_odb_backend_one_pack(
      out: Ptr[Ptr[git_odb_backend]],
      index_file: CString
  ): CInt = extern

  def git_odb_backend_pack(
      out: Ptr[Ptr[git_odb_backend]],
      objects_dir: CString
  ): CInt = extern

  def git_odb_exists(db: Ptr[git_odb], id: Ptr[git_oid]): CInt = extern

  def git_odb_exists_ext(
      db: Ptr[git_odb],
      id: Ptr[git_oid],
      flags: CUnsignedInt
  ): CInt = extern

  def git_odb_exists_prefix(
      out: Ptr[git_oid],
      db: Ptr[git_odb],
      short_id: Ptr[git_oid],
      len: size_t
  ): CInt = extern

  def git_odb_expand_ids(
      db: Ptr[git_odb],
      ids: Ptr[git_odb_expand_id],
      count: size_t
  ): CInt = extern

  def git_odb_foreach(
      db: Ptr[git_odb],
      cb: git_odb_foreach_cb,
      payload: Ptr[Byte]
  ): CInt = extern

  def git_odb_free(db: Ptr[git_odb]): Unit = extern

  def git_odb_get_backend(
      out: Ptr[Ptr[git_odb_backend]],
      odb: Ptr[git_odb],
      pos: size_t
  ): CInt = extern

  def git_odb_hash(
      out: Ptr[git_oid],
      data: Ptr[Byte],
      len: size_t,
      `type`: git_object_t
  ): CInt = extern

  def git_odb_hashfile(
      out: Ptr[git_oid],
      path: CString,
      `type`: git_object_t
  ): CInt = extern

  def git_odb_new(out: Ptr[Ptr[git_odb]]): CInt = extern

  def git_odb_num_backends(odb: Ptr[git_odb]): size_t = extern

  def git_odb_object_data(`object`: Ptr[git_odb_object]): Ptr[Byte] = extern

  def git_odb_object_dup(
      dest: Ptr[Ptr[git_odb_object]],
      source: Ptr[git_odb_object]
  ): CInt = extern

  def git_odb_object_free(`object`: Ptr[git_odb_object]): Unit = extern

  def git_odb_object_id(`object`: Ptr[git_odb_object]): Ptr[git_oid] = extern

  def git_odb_object_size(`object`: Ptr[git_odb_object]): size_t = extern

  def git_odb_object_type(`object`: Ptr[git_odb_object]): git_object_t = extern

  def git_odb_open(out: Ptr[Ptr[git_odb]], objects_dir: CString): CInt = extern

  def git_odb_open_rstream(
      out: Ptr[Ptr[git_odb_stream]],
      len: Ptr[size_t],
      `type`: Ptr[git_object_t],
      db: Ptr[git_odb],
      oid: Ptr[git_oid]
  ): CInt = extern

  def git_odb_open_wstream(
      out: Ptr[Ptr[git_odb_stream]],
      db: Ptr[git_odb],
      size: git_object_size_t,
      `type`: git_object_t
  ): CInt = extern

  def git_odb_read(
      out: Ptr[Ptr[git_odb_object]],
      db: Ptr[git_odb],
      id: Ptr[git_oid]
  ): CInt = extern

  def git_odb_read_header(
      len_out: Ptr[size_t],
      type_out: Ptr[git_object_t],
      db: Ptr[git_odb],
      id: Ptr[git_oid]
  ): CInt = extern

  def git_odb_read_prefix(
      out: Ptr[Ptr[git_odb_object]],
      db: Ptr[git_odb],
      short_id: Ptr[git_oid],
      len: size_t
  ): CInt = extern

  def git_odb_refresh(db: Ptr[git_odb]): CInt = extern

  def git_odb_set_commit_graph(
      odb: Ptr[git_odb],
      cgraph: Ptr[git_commit_graph]
  ): CInt = extern

  def git_odb_stream_finalize_write(
      out: Ptr[git_oid],
      stream: Ptr[git_odb_stream]
  ): CInt = extern

  def git_odb_stream_free(stream: Ptr[git_odb_stream]): Unit = extern

  def git_odb_stream_read(
      stream: Ptr[git_odb_stream],
      buffer: CString,
      len: size_t
  ): CInt = extern

  def git_odb_stream_write(
      stream: Ptr[git_odb_stream],
      buffer: CString,
      len: size_t
  ): CInt = extern

  def git_odb_write(
      out: Ptr[git_oid],
      odb: Ptr[git_odb],
      data: Ptr[Byte],
      len: size_t,
      `type`: git_object_t
  ): CInt = extern

  def git_odb_write_multi_pack_index(db: Ptr[git_odb]): CInt = extern

  def git_odb_write_pack(
      out: Ptr[Ptr[git_odb_writepack]],
      db: Ptr[git_odb],
      progress_cb: git_indexer_progress_cb,
      progress_payload: Ptr[Byte]
  ): CInt = extern

  def git_oid_cmp(a: Ptr[git_oid], b: Ptr[git_oid]): CInt = extern

  def git_oid_cpy(out: Ptr[git_oid], src: Ptr[git_oid]): CInt = extern

  def git_oid_equal(a: Ptr[git_oid], b: Ptr[git_oid]): CInt = extern

  def git_oid_fmt(out: CString, id: Ptr[git_oid]): CInt = extern

  def git_oid_fromraw(out: Ptr[git_oid], raw: Ptr[CUnsignedChar]): CInt = extern

  def git_oid_fromstr(out: Ptr[git_oid], str: CString): CInt = extern

  def git_oid_fromstrn(out: Ptr[git_oid], str: CString, length: size_t): CInt =
    extern

  def git_oid_fromstrp(out: Ptr[git_oid], str: CString): CInt = extern

  def git_oid_is_zero(id: Ptr[git_oid]): CInt = extern

  def git_oid_iszero(id: Ptr[git_oid]): CInt = extern

  def git_oid_ncmp(a: Ptr[git_oid], b: Ptr[git_oid], len: size_t): CInt = extern

  def git_oid_nfmt(out: CString, n: size_t, id: Ptr[git_oid]): CInt = extern

  def git_oid_pathfmt(out: CString, id: Ptr[git_oid]): CInt = extern

  def git_oid_shorten_add(os: Ptr[git_oid_shorten], text_id: CString): CInt =
    extern

  def git_oid_shorten_free(os: Ptr[git_oid_shorten]): Unit = extern

  def git_oid_shorten_new(min_length: size_t): Ptr[git_oid_shorten] = extern

  def git_oid_strcmp(id: Ptr[git_oid], str: CString): CInt = extern

  def git_oid_streq(id: Ptr[git_oid], str: CString): CInt = extern

  def git_oid_tostr(out: CString, n: size_t, id: Ptr[git_oid]): CString = extern

  def git_oid_tostr_s(oid: Ptr[git_oid]): CString = extern

  def git_oidarray_dispose(array: Ptr[git_oidarray]): Unit = extern

  def git_oidarray_free(array: Ptr[git_oidarray]): Unit = extern

  def git_packbuilder_foreach(
      pb: Ptr[git_packbuilder],
      cb: git_packbuilder_foreach_cb,
      payload: Ptr[Byte]
  ): CInt = extern

  def git_packbuilder_free(pb: Ptr[git_packbuilder]): Unit = extern

  def git_packbuilder_hash(pb: Ptr[git_packbuilder]): Ptr[git_oid] = extern

  def git_packbuilder_insert(
      pb: Ptr[git_packbuilder],
      id: Ptr[git_oid],
      name: CString
  ): CInt = extern

  def git_packbuilder_insert_commit(
      pb: Ptr[git_packbuilder],
      id: Ptr[git_oid]
  ): CInt = extern

  def git_packbuilder_insert_recur(
      pb: Ptr[git_packbuilder],
      id: Ptr[git_oid],
      name: CString
  ): CInt = extern

  def git_packbuilder_insert_tree(
      pb: Ptr[git_packbuilder],
      id: Ptr[git_oid]
  ): CInt = extern

  def git_packbuilder_insert_walk(
      pb: Ptr[git_packbuilder],
      walk: Ptr[git_revwalk]
  ): CInt = extern

  def git_packbuilder_name(pb: Ptr[git_packbuilder]): CString = extern

  def git_packbuilder_new(
      out: Ptr[Ptr[git_packbuilder]],
      repo: Ptr[git_repository]
  ): CInt = extern

  def git_packbuilder_object_count(pb: Ptr[git_packbuilder]): size_t = extern

  def git_packbuilder_set_callbacks(
      pb: Ptr[git_packbuilder],
      progress_cb: git_packbuilder_progress,
      progress_cb_payload: Ptr[Byte]
  ): CInt = extern

  def git_packbuilder_set_threads(
      pb: Ptr[git_packbuilder],
      n: CUnsignedInt
  ): CUnsignedInt = extern

  def git_packbuilder_write(
      pb: Ptr[git_packbuilder],
      path: CString,
      mode: CUnsignedInt,
      progress_cb: git_indexer_progress_cb,
      progress_cb_payload: Ptr[Byte]
  ): CInt = extern

  def git_packbuilder_write_buf(
      buf: Ptr[git_buf],
      pb: Ptr[git_packbuilder]
  ): CInt = extern

  def git_packbuilder_written(pb: Ptr[git_packbuilder]): size_t = extern

  def git_patch_free(patch: Ptr[git_patch]): Unit = extern

  def git_patch_from_blob_and_buffer(
      out: Ptr[Ptr[git_patch]],
      old_blob: Ptr[git_blob],
      old_as_path: CString,
      buffer: Ptr[Byte],
      buffer_len: size_t,
      buffer_as_path: CString,
      opts: Ptr[git_diff_options]
  ): CInt = extern

  def git_patch_from_blobs(
      out: Ptr[Ptr[git_patch]],
      old_blob: Ptr[git_blob],
      old_as_path: CString,
      new_blob: Ptr[git_blob],
      new_as_path: CString,
      opts: Ptr[git_diff_options]
  ): CInt = extern

  def git_patch_from_buffers(
      out: Ptr[Ptr[git_patch]],
      old_buffer: Ptr[Byte],
      old_len: size_t,
      old_as_path: CString,
      new_buffer: Ptr[Byte],
      new_len: size_t,
      new_as_path: CString,
      opts: Ptr[git_diff_options]
  ): CInt = extern

  def git_patch_from_diff(
      out: Ptr[Ptr[git_patch]],
      diff: Ptr[git_diff],
      idx: size_t
  ): CInt = extern

  def git_patch_get_delta(patch: Ptr[git_patch]): Ptr[git_diff_delta] = extern

  def git_patch_get_hunk(
      out: Ptr[Ptr[git_diff_hunk]],
      lines_in_hunk: Ptr[size_t],
      patch: Ptr[git_patch],
      hunk_idx: size_t
  ): CInt = extern

  def git_patch_get_line_in_hunk(
      out: Ptr[Ptr[git_diff_line]],
      patch: Ptr[git_patch],
      hunk_idx: size_t,
      line_of_hunk: size_t
  ): CInt = extern

  def git_patch_line_stats(
      total_context: Ptr[size_t],
      total_additions: Ptr[size_t],
      total_deletions: Ptr[size_t],
      patch: Ptr[git_patch]
  ): CInt = extern

  def git_patch_num_hunks(patch: Ptr[git_patch]): size_t = extern

  def git_patch_num_lines_in_hunk(
      patch: Ptr[git_patch],
      hunk_idx: size_t
  ): CInt = extern

  def git_patch_owner(patch: Ptr[git_patch]): Ptr[git_repository] = extern

  def git_patch_print(
      patch: Ptr[git_patch],
      print_cb: git_diff_line_cb,
      payload: Ptr[Byte]
  ): CInt = extern

  def git_patch_size(
      patch: Ptr[git_patch],
      include_context: CInt,
      include_hunk_headers: CInt,
      include_file_headers: CInt
  ): size_t = extern

  def git_patch_to_buf(out: Ptr[git_buf], patch: Ptr[git_patch]): CInt = extern

  def git_pathspec_free(ps: Ptr[git_pathspec]): Unit = extern

  def git_pathspec_match_diff(
      out: Ptr[Ptr[git_pathspec_match_list]],
      diff: Ptr[git_diff],
      flags: uint32_t,
      ps: Ptr[git_pathspec]
  ): CInt = extern

  def git_pathspec_match_index(
      out: Ptr[Ptr[git_pathspec_match_list]],
      index: Ptr[git_index],
      flags: uint32_t,
      ps: Ptr[git_pathspec]
  ): CInt = extern

  def git_pathspec_match_list_diff_entry(
      m: Ptr[git_pathspec_match_list],
      pos: size_t
  ): Ptr[git_diff_delta] = extern

  def git_pathspec_match_list_entry(
      m: Ptr[git_pathspec_match_list],
      pos: size_t
  ): CString = extern

  def git_pathspec_match_list_entrycount(
      m: Ptr[git_pathspec_match_list]
  ): size_t = extern

  def git_pathspec_match_list_failed_entry(
      m: Ptr[git_pathspec_match_list],
      pos: size_t
  ): CString = extern

  def git_pathspec_match_list_failed_entrycount(
      m: Ptr[git_pathspec_match_list]
  ): size_t = extern

  def git_pathspec_match_list_free(m: Ptr[git_pathspec_match_list]): Unit =
    extern

  def git_pathspec_match_tree(
      out: Ptr[Ptr[git_pathspec_match_list]],
      tree: Ptr[git_tree],
      flags: uint32_t,
      ps: Ptr[git_pathspec]
  ): CInt = extern

  def git_pathspec_match_workdir(
      out: Ptr[Ptr[git_pathspec_match_list]],
      repo: Ptr[git_repository],
      flags: uint32_t,
      ps: Ptr[git_pathspec]
  ): CInt = extern

  def git_pathspec_matches_path(
      ps: Ptr[git_pathspec],
      flags: uint32_t,
      path: CString
  ): CInt = extern

  def git_pathspec_new(
      out: Ptr[Ptr[git_pathspec]],
      pathspec: Ptr[git_strarray]
  ): CInt = extern

  def git_proxy_init_options(
      opts: Ptr[git_proxy_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_proxy_options_init(
      opts: Ptr[git_proxy_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_push_init_options(
      opts: Ptr[git_push_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_push_options_init(
      opts: Ptr[git_push_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_rebase_abort(rebase: Ptr[git_rebase]): CInt = extern

  def git_rebase_commit(
      id: Ptr[git_oid],
      rebase: Ptr[git_rebase],
      author: Ptr[git_signature],
      committer: Ptr[git_signature],
      message_encoding: CString,
      message: CString
  ): CInt = extern

  def git_rebase_finish(
      rebase: Ptr[git_rebase],
      signature: Ptr[git_signature]
  ): CInt = extern

  def git_rebase_free(rebase: Ptr[git_rebase]): Unit = extern

  def git_rebase_init(
      out: Ptr[Ptr[git_rebase]],
      repo: Ptr[git_repository],
      branch: Ptr[git_annotated_commit],
      upstream: Ptr[git_annotated_commit],
      onto: Ptr[git_annotated_commit],
      opts: Ptr[git_rebase_options]
  ): CInt = extern

  def git_rebase_init_options(
      opts: Ptr[git_rebase_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_rebase_inmemory_index(
      index: Ptr[Ptr[git_index]],
      rebase: Ptr[git_rebase]
  ): CInt = extern

  def git_rebase_next(
      operation: Ptr[Ptr[git_rebase_operation]],
      rebase: Ptr[git_rebase]
  ): CInt = extern

  def git_rebase_onto_id(rebase: Ptr[git_rebase]): Ptr[git_oid] = extern

  def git_rebase_onto_name(rebase: Ptr[git_rebase]): CString = extern

  def git_rebase_open(
      out: Ptr[Ptr[git_rebase]],
      repo: Ptr[git_repository],
      opts: Ptr[git_rebase_options]
  ): CInt = extern

  def git_rebase_operation_byindex(
      rebase: Ptr[git_rebase],
      idx: size_t
  ): Ptr[git_rebase_operation] = extern

  def git_rebase_operation_current(rebase: Ptr[git_rebase]): size_t = extern

  def git_rebase_operation_entrycount(rebase: Ptr[git_rebase]): size_t = extern

  def git_rebase_options_init(
      opts: Ptr[git_rebase_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_rebase_orig_head_id(rebase: Ptr[git_rebase]): Ptr[git_oid] = extern

  def git_rebase_orig_head_name(rebase: Ptr[git_rebase]): CString = extern

  def git_refdb_compress(refdb: Ptr[git_refdb]): CInt = extern

  def git_refdb_free(refdb: Ptr[git_refdb]): Unit = extern

  def git_refdb_new(out: Ptr[Ptr[git_refdb]], repo: Ptr[git_repository]): CInt =
    extern

  def git_refdb_open(
      out: Ptr[Ptr[git_refdb]],
      repo: Ptr[git_repository]
  ): CInt = extern

  def git_reference_cmp(
      ref1: Ptr[git_reference],
      ref2: Ptr[git_reference]
  ): CInt = extern

  def git_reference_create(
      out: Ptr[Ptr[git_reference]],
      repo: Ptr[git_repository],
      name: CString,
      id: Ptr[git_oid],
      force: CInt,
      log_message: CString
  ): CInt = extern

  def git_reference_create_matching(
      out: Ptr[Ptr[git_reference]],
      repo: Ptr[git_repository],
      name: CString,
      id: Ptr[git_oid],
      force: CInt,
      current_id: Ptr[git_oid],
      log_message: CString
  ): CInt = extern

  def git_reference_delete(ref: Ptr[git_reference]): CInt = extern

  def git_reference_dup(
      dest: Ptr[Ptr[git_reference]],
      source: Ptr[git_reference]
  ): CInt = extern

  def git_reference_dwim(
      out: Ptr[Ptr[git_reference]],
      repo: Ptr[git_repository],
      shorthand: CString
  ): CInt = extern

  def git_reference_ensure_log(
      repo: Ptr[git_repository],
      refname: CString
  ): CInt = extern

  def git_reference_foreach(
      repo: Ptr[git_repository],
      callback: git_reference_foreach_cb,
      payload: Ptr[Byte]
  ): CInt = extern

  def git_reference_foreach_glob(
      repo: Ptr[git_repository],
      glob: CString,
      callback: git_reference_foreach_name_cb,
      payload: Ptr[Byte]
  ): CInt = extern

  def git_reference_foreach_name(
      repo: Ptr[git_repository],
      callback: git_reference_foreach_name_cb,
      payload: Ptr[Byte]
  ): CInt = extern

  def git_reference_free(ref: Ptr[git_reference]): Unit = extern

  def git_reference_has_log(repo: Ptr[git_repository], refname: CString): CInt =
    extern

  def git_reference_is_branch(ref: Ptr[git_reference]): CInt = extern

  def git_reference_is_note(ref: Ptr[git_reference]): CInt = extern

  def git_reference_is_remote(ref: Ptr[git_reference]): CInt = extern

  def git_reference_is_tag(ref: Ptr[git_reference]): CInt = extern

  def git_reference_is_valid_name(refname: CString): CInt = extern

  def git_reference_iterator_free(iter: Ptr[git_reference_iterator]): Unit =
    extern

  def git_reference_iterator_glob_new(
      out: Ptr[Ptr[git_reference_iterator]],
      repo: Ptr[git_repository],
      glob: CString
  ): CInt = extern

  def git_reference_iterator_new(
      out: Ptr[Ptr[git_reference_iterator]],
      repo: Ptr[git_repository]
  ): CInt = extern

  def git_reference_list(
      array: Ptr[git_strarray],
      repo: Ptr[git_repository]
  ): CInt = extern

  def git_reference_lookup(
      out: Ptr[Ptr[git_reference]],
      repo: Ptr[git_repository],
      name: CString
  ): CInt = extern

  def git_reference_name(ref: Ptr[git_reference]): CString = extern

  def git_reference_name_is_valid(valid: Ptr[CInt], refname: CString): CInt =
    extern

  def git_reference_name_to_id(
      out: Ptr[git_oid],
      repo: Ptr[git_repository],
      name: CString
  ): CInt = extern

  def git_reference_next(
      out: Ptr[Ptr[git_reference]],
      iter: Ptr[git_reference_iterator]
  ): CInt = extern

  def git_reference_next_name(
      out: Ptr[CString],
      iter: Ptr[git_reference_iterator]
  ): CInt = extern

  def git_reference_normalize_name(
      buffer_out: CString,
      buffer_size: size_t,
      name: CString,
      flags: CUnsignedInt
  ): CInt = extern

  def git_reference_owner(ref: Ptr[git_reference]): Ptr[git_repository] = extern

  def git_reference_peel(
      out: Ptr[Ptr[git_object]],
      ref: Ptr[git_reference],
      `type`: git_object_t
  ): CInt = extern

  def git_reference_remove(repo: Ptr[git_repository], name: CString): CInt =
    extern

  def git_reference_rename(
      new_ref: Ptr[Ptr[git_reference]],
      ref: Ptr[git_reference],
      new_name: CString,
      force: CInt,
      log_message: CString
  ): CInt = extern

  def git_reference_resolve(
      out: Ptr[Ptr[git_reference]],
      ref: Ptr[git_reference]
  ): CInt = extern

  def git_reference_set_target(
      out: Ptr[Ptr[git_reference]],
      ref: Ptr[git_reference],
      id: Ptr[git_oid],
      log_message: CString
  ): CInt = extern

  def git_reference_shorthand(ref: Ptr[git_reference]): CString = extern

  def git_reference_symbolic_create(
      out: Ptr[Ptr[git_reference]],
      repo: Ptr[git_repository],
      name: CString,
      target: CString,
      force: CInt,
      log_message: CString
  ): CInt = extern

  def git_reference_symbolic_create_matching(
      out: Ptr[Ptr[git_reference]],
      repo: Ptr[git_repository],
      name: CString,
      target: CString,
      force: CInt,
      current_value: CString,
      log_message: CString
  ): CInt = extern

  def git_reference_symbolic_set_target(
      out: Ptr[Ptr[git_reference]],
      ref: Ptr[git_reference],
      target: CString,
      log_message: CString
  ): CInt = extern

  def git_reference_symbolic_target(ref: Ptr[git_reference]): CString = extern

  def git_reference_target(ref: Ptr[git_reference]): Ptr[git_oid] = extern

  def git_reference_target_peel(ref: Ptr[git_reference]): Ptr[git_oid] = extern

  def git_reference_type(ref: Ptr[git_reference]): git_reference_t = extern

  def git_reflog_append(
      reflog: Ptr[git_reflog],
      id: Ptr[git_oid],
      committer: Ptr[git_signature],
      msg: CString
  ): CInt = extern

  def git_reflog_delete(repo: Ptr[git_repository], name: CString): CInt = extern

  def git_reflog_drop(
      reflog: Ptr[git_reflog],
      idx: size_t,
      rewrite_previous_entry: CInt
  ): CInt = extern

  def git_reflog_entry_byindex(
      reflog: Ptr[git_reflog],
      idx: size_t
  ): Ptr[git_reflog_entry] = extern

  def git_reflog_entry_committer(
      entry: Ptr[git_reflog_entry]
  ): Ptr[git_signature] = extern

  def git_reflog_entry_id_new(entry: Ptr[git_reflog_entry]): Ptr[git_oid] =
    extern

  def git_reflog_entry_id_old(entry: Ptr[git_reflog_entry]): Ptr[git_oid] =
    extern

  def git_reflog_entry_message(entry: Ptr[git_reflog_entry]): CString = extern

  def git_reflog_entrycount(reflog: Ptr[git_reflog]): size_t = extern

  def git_reflog_free(reflog: Ptr[git_reflog]): Unit = extern

  def git_reflog_read(
      out: Ptr[Ptr[git_reflog]],
      repo: Ptr[git_repository],
      name: CString
  ): CInt = extern

  def git_reflog_rename(
      repo: Ptr[git_repository],
      old_name: CString,
      name: CString
  ): CInt = extern

  def git_reflog_write(reflog: Ptr[git_reflog]): CInt = extern

  def git_refspec_direction(spec: Ptr[git_refspec]): git_direction = extern

  def git_refspec_dst(refspec: Ptr[git_refspec]): CString = extern

  def git_refspec_dst_matches(
      refspec: Ptr[git_refspec],
      refname: CString
  ): CInt = extern

  def git_refspec_force(refspec: Ptr[git_refspec]): CInt = extern

  def git_refspec_free(refspec: Ptr[git_refspec]): Unit = extern

  def git_refspec_parse(
      refspec: Ptr[Ptr[git_refspec]],
      input: CString,
      is_fetch: CInt
  ): CInt = extern

  def git_refspec_rtransform(
      out: Ptr[git_buf],
      spec: Ptr[git_refspec],
      name: CString
  ): CInt = extern

  def git_refspec_src(refspec: Ptr[git_refspec]): CString = extern

  def git_refspec_src_matches(
      refspec: Ptr[git_refspec],
      refname: CString
  ): CInt = extern

  def git_refspec_string(refspec: Ptr[git_refspec]): CString = extern

  def git_refspec_transform(
      out: Ptr[git_buf],
      spec: Ptr[git_refspec],
      name: CString
  ): CInt = extern

  def git_remote_add_fetch(
      repo: Ptr[git_repository],
      remote: CString,
      refspec: CString
  ): CInt = extern

  def git_remote_add_push(
      repo: Ptr[git_repository],
      remote: CString,
      refspec: CString
  ): CInt = extern

  def git_remote_autotag(remote: Ptr[git_remote]): git_remote_autotag_option_t =
    extern

  def git_remote_connect(
      remote: Ptr[git_remote],
      direction: git_direction,
      callbacks: Ptr[git_remote_callbacks],
      proxy_opts: Ptr[git_proxy_options],
      custom_headers: Ptr[git_strarray]
  ): CInt = extern

  def git_remote_connect_ext(
      remote: Ptr[git_remote],
      direction: git_direction,
      opts: Ptr[git_remote_connect_options]
  ): CInt = extern

  def git_remote_connect_options_init(
      opts: Ptr[git_remote_connect_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_remote_connected(remote: Ptr[git_remote]): CInt = extern

  def git_remote_create(
      out: Ptr[Ptr[git_remote]],
      repo: Ptr[git_repository],
      name: CString,
      url: CString
  ): CInt = extern

  def git_remote_create_anonymous(
      out: Ptr[Ptr[git_remote]],
      repo: Ptr[git_repository],
      url: CString
  ): CInt = extern

  def git_remote_create_detached(
      out: Ptr[Ptr[git_remote]],
      url: CString
  ): CInt = extern

  def git_remote_create_init_options(
      opts: Ptr[git_remote_create_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_remote_create_options_init(
      opts: Ptr[git_remote_create_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_remote_create_with_fetchspec(
      out: Ptr[Ptr[git_remote]],
      repo: Ptr[git_repository],
      name: CString,
      url: CString,
      fetch: CString
  ): CInt = extern

  def git_remote_create_with_opts(
      out: Ptr[Ptr[git_remote]],
      url: CString,
      opts: Ptr[git_remote_create_options]
  ): CInt = extern

  def git_remote_default_branch(
      out: Ptr[git_buf],
      remote: Ptr[git_remote]
  ): CInt = extern

  def git_remote_delete(repo: Ptr[git_repository], name: CString): CInt = extern

  def git_remote_disconnect(remote: Ptr[git_remote]): CInt = extern

  def git_remote_download(
      remote: Ptr[git_remote],
      refspecs: Ptr[git_strarray],
      opts: Ptr[git_fetch_options]
  ): CInt = extern

  def git_remote_dup(
      dest: Ptr[Ptr[git_remote]],
      source: Ptr[git_remote]
  ): CInt = extern

  def git_remote_fetch(
      remote: Ptr[git_remote],
      refspecs: Ptr[git_strarray],
      opts: Ptr[git_fetch_options],
      reflog_message: CString
  ): CInt = extern

  def git_remote_free(remote: Ptr[git_remote]): Unit = extern

  def git_remote_get_fetch_refspecs(
      array: Ptr[git_strarray],
      remote: Ptr[git_remote]
  ): CInt = extern

  def git_remote_get_push_refspecs(
      array: Ptr[git_strarray],
      remote: Ptr[git_remote]
  ): CInt = extern

  def git_remote_get_refspec(
      remote: Ptr[git_remote],
      n: size_t
  ): Ptr[git_refspec] = extern

  def git_remote_init_callbacks(
      opts: Ptr[git_remote_callbacks],
      version: CUnsignedInt
  ): CInt = extern

  def git_remote_is_valid_name(remote_name: CString): CInt = extern

  def git_remote_list(out: Ptr[git_strarray], repo: Ptr[git_repository]): CInt =
    extern

  def git_remote_lookup(
      out: Ptr[Ptr[git_remote]],
      repo: Ptr[git_repository],
      name: CString
  ): CInt = extern

  def git_remote_ls(
      out: Ptr[Ptr[Ptr[git_remote_head]]],
      size: Ptr[size_t],
      remote: Ptr[git_remote]
  ): CInt = extern

  def git_remote_name(remote: Ptr[git_remote]): CString = extern

  def git_remote_name_is_valid(valid: Ptr[CInt], remote_name: CString): CInt =
    extern

  def git_remote_owner(remote: Ptr[git_remote]): Ptr[git_repository] = extern

  def git_remote_prune(
      remote: Ptr[git_remote],
      callbacks: Ptr[git_remote_callbacks]
  ): CInt = extern

  def git_remote_prune_refs(remote: Ptr[git_remote]): CInt = extern

  def git_remote_push(
      remote: Ptr[git_remote],
      refspecs: Ptr[git_strarray],
      opts: Ptr[git_push_options]
  ): CInt = extern

  def git_remote_pushurl(remote: Ptr[git_remote]): CString = extern

  def git_remote_refspec_count(remote: Ptr[git_remote]): size_t = extern

  def git_remote_rename(
      problems: Ptr[git_strarray],
      repo: Ptr[git_repository],
      name: CString,
      new_name: CString
  ): CInt = extern

  def git_remote_set_autotag(
      repo: Ptr[git_repository],
      remote: CString,
      value: git_remote_autotag_option_t
  ): CInt = extern

  def git_remote_set_instance_pushurl(
      remote: Ptr[git_remote],
      url: CString
  ): CInt = extern

  def git_remote_set_instance_url(remote: Ptr[git_remote], url: CString): CInt =
    extern

  def git_remote_set_pushurl(
      repo: Ptr[git_repository],
      remote: CString,
      url: CString
  ): CInt = extern

  def git_remote_set_url(
      repo: Ptr[git_repository],
      remote: CString,
      url: CString
  ): CInt = extern

  def git_remote_stats(remote: Ptr[git_remote]): Ptr[git_indexer_progress] =
    extern

  def git_remote_stop(remote: Ptr[git_remote]): CInt = extern

  def git_remote_update_tips(
      remote: Ptr[git_remote],
      callbacks: Ptr[git_remote_callbacks],
      update_fetchhead: CInt,
      download_tags: git_remote_autotag_option_t,
      reflog_message: CString
  ): CInt = extern

  def git_remote_upload(
      remote: Ptr[git_remote],
      refspecs: Ptr[git_strarray],
      opts: Ptr[git_push_options]
  ): CInt = extern

  def git_remote_url(remote: Ptr[git_remote]): CString = extern

  def git_repository_commondir(repo: Ptr[git_repository]): CString = extern

  def git_repository_config(
      out: Ptr[Ptr[git_config]],
      repo: Ptr[git_repository]
  ): CInt = extern

  def git_repository_config_snapshot(
      out: Ptr[Ptr[git_config]],
      repo: Ptr[git_repository]
  ): CInt = extern

  def git_repository_detach_head(repo: Ptr[git_repository]): CInt = extern

  def git_repository_discover(
      out: Ptr[git_buf],
      start_path: CString,
      across_fs: CInt,
      ceiling_dirs: CString
  ): CInt = extern

  def git_repository_fetchhead_foreach(
      repo: Ptr[git_repository],
      callback: git_repository_fetchhead_foreach_cb,
      payload: Ptr[Byte]
  ): CInt = extern

  def git_repository_free(repo: Ptr[git_repository]): Unit = extern

  def git_repository_get_namespace(repo: Ptr[git_repository]): CString = extern

  def git_repository_hashfile(
      out: Ptr[git_oid],
      repo: Ptr[git_repository],
      path: CString,
      `type`: git_object_t,
      as_path: CString
  ): CInt = extern

  def git_repository_head(
      out: Ptr[Ptr[git_reference]],
      repo: Ptr[git_repository]
  ): CInt = extern

  def git_repository_head_detached(repo: Ptr[git_repository]): CInt = extern

  def git_repository_head_detached_for_worktree(
      repo: Ptr[git_repository],
      name: CString
  ): CInt = extern

  def git_repository_head_for_worktree(
      out: Ptr[Ptr[git_reference]],
      repo: Ptr[git_repository],
      name: CString
  ): CInt = extern

  def git_repository_head_unborn(repo: Ptr[git_repository]): CInt = extern

  def git_repository_ident(
      name: Ptr[CString],
      email: Ptr[CString],
      repo: Ptr[git_repository]
  ): CInt = extern

  def git_repository_index(
      out: Ptr[Ptr[git_index]],
      repo: Ptr[git_repository]
  ): CInt = extern

  def git_repository_init(
      out: Ptr[Ptr[git_repository]],
      path: CString,
      is_bare: CUnsignedInt
  ): CInt = extern

  def git_repository_init_ext(
      out: Ptr[Ptr[git_repository]],
      repo_path: CString,
      opts: Ptr[git_repository_init_options]
  ): CInt = extern

  def git_repository_init_init_options(
      opts: Ptr[git_repository_init_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_repository_init_options_init(
      opts: Ptr[git_repository_init_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_repository_is_bare(repo: Ptr[git_repository]): CInt = extern

  def git_repository_is_empty(repo: Ptr[git_repository]): CInt = extern

  def git_repository_is_shallow(repo: Ptr[git_repository]): CInt = extern

  def git_repository_is_worktree(repo: Ptr[git_repository]): CInt = extern

  def git_repository_item_path(
      out: Ptr[git_buf],
      repo: Ptr[git_repository],
      item: git_repository_item_t
  ): CInt = extern

  def git_repository_mergehead_foreach(
      repo: Ptr[git_repository],
      callback: git_repository_mergehead_foreach_cb,
      payload: Ptr[Byte]
  ): CInt = extern

  def git_repository_message(
      out: Ptr[git_buf],
      repo: Ptr[git_repository]
  ): CInt = extern

  def git_repository_message_remove(repo: Ptr[git_repository]): CInt = extern

  def git_repository_odb(
      out: Ptr[Ptr[git_odb]],
      repo: Ptr[git_repository]
  ): CInt = extern

  def git_repository_open(out: Ptr[Ptr[git_repository]], path: CString): CInt =
    extern

  def git_repository_open_bare(
      out: Ptr[Ptr[git_repository]],
      bare_path: CString
  ): CInt = extern

  def git_repository_open_ext(
      out: Ptr[Ptr[git_repository]],
      path: CString,
      flags: CUnsignedInt,
      ceiling_dirs: CString
  ): CInt = extern

  def git_repository_open_from_worktree(
      out: Ptr[Ptr[git_repository]],
      wt: Ptr[git_worktree]
  ): CInt = extern

  def git_repository_path(repo: Ptr[git_repository]): CString = extern

  def git_repository_refdb(
      out: Ptr[Ptr[git_refdb]],
      repo: Ptr[git_repository]
  ): CInt = extern

  def git_repository_set_head(
      repo: Ptr[git_repository],
      refname: CString
  ): CInt = extern

  def git_repository_set_head_detached(
      repo: Ptr[git_repository],
      committish: Ptr[git_oid]
  ): CInt = extern

  def git_repository_set_head_detached_from_annotated(
      repo: Ptr[git_repository],
      committish: Ptr[git_annotated_commit]
  ): CInt = extern

  def git_repository_set_ident(
      repo: Ptr[git_repository],
      name: CString,
      email: CString
  ): CInt = extern

  def git_repository_set_namespace(
      repo: Ptr[git_repository],
      nmspace: CString
  ): CInt = extern

  def git_repository_set_workdir(
      repo: Ptr[git_repository],
      workdir: CString,
      update_gitlink: CInt
  ): CInt = extern

  def git_repository_state(repo: Ptr[git_repository]): CInt = extern

  def git_repository_state_cleanup(repo: Ptr[git_repository]): CInt = extern

  def git_repository_workdir(repo: Ptr[git_repository]): CString = extern

  def git_repository_wrap_odb(
      out: Ptr[Ptr[git_repository]],
      odb: Ptr[git_odb]
  ): CInt = extern

  def git_reset(
      repo: Ptr[git_repository],
      target: Ptr[git_object],
      reset_type: git_reset_t,
      checkout_opts: Ptr[git_checkout_options]
  ): CInt = extern

  def git_reset_default(
      repo: Ptr[git_repository],
      target: Ptr[git_object],
      pathspecs: Ptr[git_strarray]
  ): CInt = extern

  def git_reset_from_annotated(
      repo: Ptr[git_repository],
      commit: Ptr[git_annotated_commit],
      reset_type: git_reset_t,
      checkout_opts: Ptr[git_checkout_options]
  ): CInt = extern

  def git_revert(
      repo: Ptr[git_repository],
      commit: Ptr[git_commit],
      given_opts: Ptr[git_revert_options]
  ): CInt = extern

  def git_revert_commit(
      out: Ptr[Ptr[git_index]],
      repo: Ptr[git_repository],
      revert_commit: Ptr[git_commit],
      our_commit: Ptr[git_commit],
      mainline: CUnsignedInt,
      merge_options: Ptr[git_merge_options]
  ): CInt = extern

  def git_revert_init_options(
      opts: Ptr[git_revert_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_revert_options_init(
      opts: Ptr[git_revert_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_revparse(
      revspec: Ptr[git_revspec],
      repo: Ptr[git_repository],
      spec: CString
  ): CInt = extern

  def git_revparse_ext(
      object_out: Ptr[Ptr[git_object]],
      reference_out: Ptr[Ptr[git_reference]],
      repo: Ptr[git_repository],
      spec: CString
  ): CInt = extern

  def git_revparse_single(
      out: Ptr[Ptr[git_object]],
      repo: Ptr[git_repository],
      spec: CString
  ): CInt = extern

  def git_revwalk_add_hide_cb(
      walk: Ptr[git_revwalk],
      hide_cb: git_revwalk_hide_cb,
      payload: Ptr[Byte]
  ): CInt = extern

  def git_revwalk_free(walk: Ptr[git_revwalk]): Unit = extern

  def git_revwalk_hide(walk: Ptr[git_revwalk], commit_id: Ptr[git_oid]): CInt =
    extern

  def git_revwalk_hide_glob(walk: Ptr[git_revwalk], glob: CString): CInt =
    extern

  def git_revwalk_hide_head(walk: Ptr[git_revwalk]): CInt = extern

  def git_revwalk_hide_ref(walk: Ptr[git_revwalk], refname: CString): CInt =
    extern

  def git_revwalk_new(
      out: Ptr[Ptr[git_revwalk]],
      repo: Ptr[git_repository]
  ): CInt = extern

  def git_revwalk_next(out: Ptr[git_oid], walk: Ptr[git_revwalk]): CInt = extern

  def git_revwalk_push(walk: Ptr[git_revwalk], id: Ptr[git_oid]): CInt = extern

  def git_revwalk_push_glob(walk: Ptr[git_revwalk], glob: CString): CInt =
    extern

  def git_revwalk_push_head(walk: Ptr[git_revwalk]): CInt = extern

  def git_revwalk_push_range(walk: Ptr[git_revwalk], range: CString): CInt =
    extern

  def git_revwalk_push_ref(walk: Ptr[git_revwalk], refname: CString): CInt =
    extern

  def git_revwalk_repository(walk: Ptr[git_revwalk]): Ptr[git_repository] =
    extern

  def git_revwalk_reset(walker: Ptr[git_revwalk]): CInt = extern

  def git_revwalk_simplify_first_parent(walk: Ptr[git_revwalk]): CInt = extern

  def git_revwalk_sorting(
      walk: Ptr[git_revwalk],
      sort_mode: CUnsignedInt
  ): CInt = extern

  def git_signature_default(
      out: Ptr[Ptr[git_signature]],
      repo: Ptr[git_repository]
  ): CInt = extern

  def git_signature_dup(
      dest: Ptr[Ptr[git_signature]],
      sig: Ptr[git_signature]
  ): CInt = extern

  def git_signature_free(sig: Ptr[git_signature]): Unit = extern

  def git_signature_from_buffer(
      out: Ptr[Ptr[git_signature]],
      buf: CString
  ): CInt = extern

  def git_signature_new(
      out: Ptr[Ptr[git_signature]],
      name: CString,
      email: CString,
      time: git_time_t,
      offset: CInt
  ): CInt = extern

  def git_signature_now(
      out: Ptr[Ptr[git_signature]],
      name: CString,
      email: CString
  ): CInt = extern

  def git_stash_apply(
      repo: Ptr[git_repository],
      index: size_t,
      options: Ptr[git_stash_apply_options]
  ): CInt = extern

  def git_stash_apply_init_options(
      opts: Ptr[git_stash_apply_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_stash_apply_options_init(
      opts: Ptr[git_stash_apply_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_stash_drop(repo: Ptr[git_repository], index: size_t): CInt = extern

  def git_stash_foreach(
      repo: Ptr[git_repository],
      callback: git_stash_cb,
      payload: Ptr[Byte]
  ): CInt = extern

  def git_stash_pop(
      repo: Ptr[git_repository],
      index: size_t,
      options: Ptr[git_stash_apply_options]
  ): CInt = extern

  def git_stash_save(
      out: Ptr[git_oid],
      repo: Ptr[git_repository],
      stasher: Ptr[git_signature],
      message: CString,
      flags: uint32_t
  ): CInt = extern

  def git_status_byindex(
      statuslist: Ptr[git_status_list],
      idx: size_t
  ): Ptr[git_status_entry] = extern

  def git_status_file(
      status_flags: Ptr[CUnsignedInt],
      repo: Ptr[git_repository],
      path: CString
  ): CInt = extern

  def git_status_foreach(
      repo: Ptr[git_repository],
      callback: git_status_cb,
      payload: Ptr[Byte]
  ): CInt = extern

  def git_status_foreach_ext(
      repo: Ptr[git_repository],
      opts: Ptr[git_status_options],
      callback: git_status_cb,
      payload: Ptr[Byte]
  ): CInt = extern

  def git_status_init_options(
      opts: Ptr[git_status_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_status_list_entrycount(statuslist: Ptr[git_status_list]): size_t =
    extern

  def git_status_list_free(statuslist: Ptr[git_status_list]): Unit = extern

  def git_status_list_new(
      out: Ptr[Ptr[git_status_list]],
      repo: Ptr[git_repository],
      opts: Ptr[git_status_options]
  ): CInt = extern

  def git_status_options_init(
      opts: Ptr[git_status_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_status_should_ignore(
      ignored: Ptr[CInt],
      repo: Ptr[git_repository],
      path: CString
  ): CInt = extern

  def git_strarray_copy(tgt: Ptr[git_strarray], src: Ptr[git_strarray]): CInt =
    extern

  def git_strarray_dispose(array: Ptr[git_strarray]): Unit = extern

  def git_strarray_free(array: Ptr[git_strarray]): Unit = extern

  def git_submodule_add_finalize(submodule: Ptr[git_submodule]): CInt = extern

  def git_submodule_add_setup(
      out: Ptr[Ptr[git_submodule]],
      repo: Ptr[git_repository],
      url: CString,
      path: CString,
      use_gitlink: CInt
  ): CInt = extern

  def git_submodule_add_to_index(
      submodule: Ptr[git_submodule],
      write_index: CInt
  ): CInt = extern

  def git_submodule_branch(submodule: Ptr[git_submodule]): CString = extern

  def git_submodule_clone(
      out: Ptr[Ptr[git_repository]],
      submodule: Ptr[git_submodule],
      opts: Ptr[git_submodule_update_options]
  ): CInt = extern

  def git_submodule_dup(
      out: Ptr[Ptr[git_submodule]],
      source: Ptr[git_submodule]
  ): CInt = extern

  def git_submodule_fetch_recurse_submodules(
      submodule: Ptr[git_submodule]
  ): git_submodule_recurse_t = extern

  def git_submodule_foreach(
      repo: Ptr[git_repository],
      callback: git_submodule_cb,
      payload: Ptr[Byte]
  ): CInt = extern

  def git_submodule_free(submodule: Ptr[git_submodule]): Unit = extern

  def git_submodule_head_id(submodule: Ptr[git_submodule]): Ptr[git_oid] =
    extern

  def git_submodule_ignore(
      submodule: Ptr[git_submodule]
  ): git_submodule_ignore_t = extern

  def git_submodule_index_id(submodule: Ptr[git_submodule]): Ptr[git_oid] =
    extern

  def git_submodule_init(submodule: Ptr[git_submodule], overwrite: CInt): CInt =
    extern

  def git_submodule_location(
      location_status: Ptr[CUnsignedInt],
      submodule: Ptr[git_submodule]
  ): CInt = extern

  def git_submodule_lookup(
      out: Ptr[Ptr[git_submodule]],
      repo: Ptr[git_repository],
      name: CString
  ): CInt = extern

  def git_submodule_name(submodule: Ptr[git_submodule]): CString = extern

  def git_submodule_open(
      repo: Ptr[Ptr[git_repository]],
      submodule: Ptr[git_submodule]
  ): CInt = extern

  def git_submodule_owner(submodule: Ptr[git_submodule]): Ptr[git_repository] =
    extern

  def git_submodule_path(submodule: Ptr[git_submodule]): CString = extern

  def git_submodule_reload(submodule: Ptr[git_submodule], force: CInt): CInt =
    extern

  def git_submodule_repo_init(
      out: Ptr[Ptr[git_repository]],
      sm: Ptr[git_submodule],
      use_gitlink: CInt
  ): CInt = extern

  def git_submodule_resolve_url(
      out: Ptr[git_buf],
      repo: Ptr[git_repository],
      url: CString
  ): CInt = extern

  def git_submodule_set_branch(
      repo: Ptr[git_repository],
      name: CString,
      branch: CString
  ): CInt = extern

  def git_submodule_set_fetch_recurse_submodules(
      repo: Ptr[git_repository],
      name: CString,
      fetch_recurse_submodules: git_submodule_recurse_t
  ): CInt = extern

  def git_submodule_set_ignore(
      repo: Ptr[git_repository],
      name: CString,
      ignore: git_submodule_ignore_t
  ): CInt = extern

  def git_submodule_set_update(
      repo: Ptr[git_repository],
      name: CString,
      update: git_submodule_update_t
  ): CInt = extern

  def git_submodule_set_url(
      repo: Ptr[git_repository],
      name: CString,
      url: CString
  ): CInt = extern

  def git_submodule_status(
      status: Ptr[CUnsignedInt],
      repo: Ptr[git_repository],
      name: CString,
      ignore: git_submodule_ignore_t
  ): CInt = extern

  def git_submodule_sync(submodule: Ptr[git_submodule]): CInt = extern

  def git_submodule_update(
      submodule: Ptr[git_submodule],
      init: CInt,
      options: Ptr[git_submodule_update_options]
  ): CInt = extern

  def git_submodule_update_init_options(
      opts: Ptr[git_submodule_update_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_submodule_update_options_init(
      opts: Ptr[git_submodule_update_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_submodule_update_strategy(
      submodule: Ptr[git_submodule]
  ): git_submodule_update_t = extern

  def git_submodule_url(submodule: Ptr[git_submodule]): CString = extern

  def git_submodule_wd_id(submodule: Ptr[git_submodule]): Ptr[git_oid] = extern

  def git_tag_annotation_create(
      oid: Ptr[git_oid],
      repo: Ptr[git_repository],
      tag_name: CString,
      target: Ptr[git_object],
      tagger: Ptr[git_signature],
      message: CString
  ): CInt = extern

  def git_tag_create(
      oid: Ptr[git_oid],
      repo: Ptr[git_repository],
      tag_name: CString,
      target: Ptr[git_object],
      tagger: Ptr[git_signature],
      message: CString,
      force: CInt
  ): CInt = extern

  def git_tag_create_from_buffer(
      oid: Ptr[git_oid],
      repo: Ptr[git_repository],
      buffer: CString,
      force: CInt
  ): CInt = extern

  def git_tag_create_frombuffer(
      oid: Ptr[git_oid],
      repo: Ptr[git_repository],
      buffer: CString,
      force: CInt
  ): CInt = extern

  def git_tag_create_lightweight(
      oid: Ptr[git_oid],
      repo: Ptr[git_repository],
      tag_name: CString,
      target: Ptr[git_object],
      force: CInt
  ): CInt = extern

  def git_tag_delete(repo: Ptr[git_repository], tag_name: CString): CInt =
    extern

  def git_tag_dup(out: Ptr[Ptr[git_tag]], source: Ptr[git_tag]): CInt = extern

  def git_tag_foreach(
      repo: Ptr[git_repository],
      callback: git_tag_foreach_cb,
      payload: Ptr[Byte]
  ): CInt = extern

  def git_tag_free(tag: Ptr[git_tag]): Unit = extern

  def git_tag_id(tag: Ptr[git_tag]): Ptr[git_oid] = extern

  def git_tag_list(
      tag_names: Ptr[git_strarray],
      repo: Ptr[git_repository]
  ): CInt = extern

  def git_tag_list_match(
      tag_names: Ptr[git_strarray],
      pattern: CString,
      repo: Ptr[git_repository]
  ): CInt = extern

  def git_tag_lookup(
      out: Ptr[Ptr[git_tag]],
      repo: Ptr[git_repository],
      id: Ptr[git_oid]
  ): CInt = extern

  def git_tag_lookup_prefix(
      out: Ptr[Ptr[git_tag]],
      repo: Ptr[git_repository],
      id: Ptr[git_oid],
      len: size_t
  ): CInt = extern

  def git_tag_message(tag: Ptr[git_tag]): CString = extern

  def git_tag_name(tag: Ptr[git_tag]): CString = extern

  def git_tag_name_is_valid(valid: Ptr[CInt], name: CString): CInt = extern

  def git_tag_owner(tag: Ptr[git_tag]): Ptr[git_repository] = extern

  def git_tag_peel(
      tag_target_out: Ptr[Ptr[git_object]],
      tag: Ptr[git_tag]
  ): CInt = extern

  def git_tag_tagger(tag: Ptr[git_tag]): Ptr[git_signature] = extern

  def git_tag_target(
      target_out: Ptr[Ptr[git_object]],
      tag: Ptr[git_tag]
  ): CInt = extern

  def git_tag_target_id(tag: Ptr[git_tag]): Ptr[git_oid] = extern

  def git_tag_target_type(tag: Ptr[git_tag]): git_object_t = extern

  def git_trace_set(level: git_trace_level_t, cb: git_trace_cb): CInt = extern

  def git_transaction_commit(tx: Ptr[git_transaction]): CInt = extern

  def git_transaction_free(tx: Ptr[git_transaction]): Unit = extern

  def git_transaction_lock_ref(
      tx: Ptr[git_transaction],
      refname: CString
  ): CInt = extern

  def git_transaction_new(
      out: Ptr[Ptr[git_transaction]],
      repo: Ptr[git_repository]
  ): CInt = extern

  def git_transaction_remove(tx: Ptr[git_transaction], refname: CString): CInt =
    extern

  def git_transaction_set_reflog(
      tx: Ptr[git_transaction],
      refname: CString,
      reflog: Ptr[git_reflog]
  ): CInt = extern

  def git_transaction_set_symbolic_target(
      tx: Ptr[git_transaction],
      refname: CString,
      target: CString,
      sig: Ptr[git_signature],
      msg: CString
  ): CInt = extern

  def git_transaction_set_target(
      tx: Ptr[git_transaction],
      refname: CString,
      target: Ptr[git_oid],
      sig: Ptr[git_signature],
      msg: CString
  ): CInt = extern

  def git_tree_create_updated(
      out: Ptr[git_oid],
      repo: Ptr[git_repository],
      baseline: Ptr[git_tree],
      nupdates: size_t,
      updates: Ptr[git_tree_update]
  ): CInt = extern

  def git_tree_dup(out: Ptr[Ptr[git_tree]], source: Ptr[git_tree]): CInt =
    extern

  def git_tree_entry_byid(
      tree: Ptr[git_tree],
      id: Ptr[git_oid]
  ): Ptr[git_tree_entry] = extern

  def git_tree_entry_byindex(
      tree: Ptr[git_tree],
      idx: size_t
  ): Ptr[git_tree_entry] = extern

  def git_tree_entry_byname(
      tree: Ptr[git_tree],
      filename: CString
  ): Ptr[git_tree_entry] = extern

  def git_tree_entry_bypath(
      out: Ptr[Ptr[git_tree_entry]],
      root: Ptr[git_tree],
      path: CString
  ): CInt = extern

  def git_tree_entry_cmp(
      e1: Ptr[git_tree_entry],
      e2: Ptr[git_tree_entry]
  ): CInt = extern

  def git_tree_entry_dup(
      dest: Ptr[Ptr[git_tree_entry]],
      source: Ptr[git_tree_entry]
  ): CInt = extern

  def git_tree_entry_filemode(entry: Ptr[git_tree_entry]): git_filemode_t =
    extern

  def git_tree_entry_filemode_raw(entry: Ptr[git_tree_entry]): git_filemode_t =
    extern

  def git_tree_entry_free(entry: Ptr[git_tree_entry]): Unit = extern

  def git_tree_entry_id(entry: Ptr[git_tree_entry]): Ptr[git_oid] = extern

  def git_tree_entry_name(entry: Ptr[git_tree_entry]): CString = extern

  def git_tree_entry_to_object(
      object_out: Ptr[Ptr[git_object]],
      repo: Ptr[git_repository],
      entry: Ptr[git_tree_entry]
  ): CInt = extern

  def git_tree_entry_type(entry: Ptr[git_tree_entry]): git_object_t = extern

  def git_tree_entrycount(tree: Ptr[git_tree]): size_t = extern

  def git_tree_free(tree: Ptr[git_tree]): Unit = extern

  def git_tree_id(tree: Ptr[git_tree]): Ptr[git_oid] = extern

  def git_tree_lookup(
      out: Ptr[Ptr[git_tree]],
      repo: Ptr[git_repository],
      id: Ptr[git_oid]
  ): CInt = extern

  def git_tree_lookup_prefix(
      out: Ptr[Ptr[git_tree]],
      repo: Ptr[git_repository],
      id: Ptr[git_oid],
      len: size_t
  ): CInt = extern

  def git_tree_owner(tree: Ptr[git_tree]): Ptr[git_repository] = extern

  def git_tree_walk(
      tree: Ptr[git_tree],
      mode: git_treewalk_mode,
      callback: git_treewalk_cb,
      payload: Ptr[Byte]
  ): CInt = extern

  def git_treebuilder_clear(bld: Ptr[git_treebuilder]): CInt = extern

  def git_treebuilder_entrycount(bld: Ptr[git_treebuilder]): size_t = extern

  def git_treebuilder_filter(
      bld: Ptr[git_treebuilder],
      filter: git_treebuilder_filter_cb,
      payload: Ptr[Byte]
  ): CInt = extern

  def git_treebuilder_free(bld: Ptr[git_treebuilder]): Unit = extern

  def git_treebuilder_get(
      bld: Ptr[git_treebuilder],
      filename: CString
  ): Ptr[git_tree_entry] = extern

  def git_treebuilder_insert(
      out: Ptr[Ptr[git_tree_entry]],
      bld: Ptr[git_treebuilder],
      filename: CString,
      id: Ptr[git_oid],
      filemode: git_filemode_t
  ): CInt = extern

  def git_treebuilder_new(
      out: Ptr[Ptr[git_treebuilder]],
      repo: Ptr[git_repository],
      source: Ptr[git_tree]
  ): CInt = extern

  def git_treebuilder_remove(
      bld: Ptr[git_treebuilder],
      filename: CString
  ): CInt = extern

  def git_treebuilder_write(id: Ptr[git_oid], bld: Ptr[git_treebuilder]): CInt =
    extern

  def git_treebuilder_write_with_buffer(
      oid: Ptr[git_oid],
      bld: Ptr[git_treebuilder],
      tree: Ptr[git_buf]
  ): CInt = extern

  def git_worktree_add(
      out: Ptr[Ptr[git_worktree]],
      repo: Ptr[git_repository],
      name: CString,
      path: CString,
      opts: Ptr[git_worktree_add_options]
  ): CInt = extern

  def git_worktree_add_init_options(
      opts: Ptr[git_worktree_add_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_worktree_add_options_init(
      opts: Ptr[git_worktree_add_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_worktree_free(wt: Ptr[git_worktree]): Unit = extern

  def git_worktree_is_locked(
      reason: Ptr[git_buf],
      wt: Ptr[git_worktree]
  ): CInt = extern

  def git_worktree_is_prunable(
      wt: Ptr[git_worktree],
      opts: Ptr[git_worktree_prune_options]
  ): CInt = extern

  def git_worktree_list(
      out: Ptr[git_strarray],
      repo: Ptr[git_repository]
  ): CInt = extern

  def git_worktree_lock(wt: Ptr[git_worktree], reason: CString): CInt = extern

  def git_worktree_lookup(
      out: Ptr[Ptr[git_worktree]],
      repo: Ptr[git_repository],
      name: CString
  ): CInt = extern

  def git_worktree_name(wt: Ptr[git_worktree]): CString = extern

  def git_worktree_open_from_repository(
      out: Ptr[Ptr[git_worktree]],
      repo: Ptr[git_repository]
  ): CInt = extern

  def git_worktree_path(wt: Ptr[git_worktree]): CString = extern

  def git_worktree_prune(
      wt: Ptr[git_worktree],
      opts: Ptr[git_worktree_prune_options]
  ): CInt = extern

  def git_worktree_prune_init_options(
      opts: Ptr[git_worktree_prune_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_worktree_prune_options_init(
      opts: Ptr[git_worktree_prune_options],
      version: CUnsignedInt
  ): CInt = extern

  def git_worktree_unlock(wt: Ptr[git_worktree]): CInt = extern

  def git_worktree_validate(wt: Ptr[git_worktree]): CInt = extern

  def giterr_clear(): Unit = extern

  def giterr_last(): Ptr[git_error] = extern

  def giterr_set_oom(): Unit = extern

  def giterr_set_str(error_class: CInt, string: CString): Unit = extern

object functions:
  import types.*, extern_functions.*

  export extern_functions.*

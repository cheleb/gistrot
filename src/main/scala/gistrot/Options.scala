package gistrot

import libgit.functions.*
import libgit.types.*

import scala.scalanative.unsafe.*

import scala.scalanative.unsigned.*
import scala.collection.MapView

enum FileStatus(val icon: String):
  override def toString: String = icon
  case WT_NEW extends FileStatus("👀")
  case WT_MODIFIED extends FileStatus("🚧")
  case WT_DELETED extends FileStatus("🗑️")
  case INDEX_NEW extends FileStatus("🚀")
  case INDEX_DELETE extends FileStatus("🔥")
  case OTHER extends FileStatus("⁉️")

object Options:
  def status(using z: Zone): Ptr[git_status_options] =
    val statusOptionPtr = git_status_options()
    git_status_options_init(statusOptionPtr, 1.toUInt)
    val statusOption = !statusOptionPtr
    statusOption.show = git_status_show_t.GIT_STATUS_SHOW_INDEX_AND_WORKDIR
    statusOption.flags = git_status_opt_t.GIT_STATUS_OPT_INCLUDE_UNTRACKED.uint
    statusOptionPtr

def diffs(repoRef: Ptr[Ptr[git_repository]])(using
    z: Zone
): MapView[FileStatus, Int] =
  import git_status_t.*
  val statusPtr = alloc[Ptr[git_status_list]](1)
  val stats = git_status_list_new(statusPtr, !repoRef, Options.status)
  val diffs = git_status_list_entrycount(!statusPtr)

  (0 until diffs.toInt)
    .map { i =>
      val statusEntry = git_status_byindex(!statusPtr, i.toUInt)
      (!statusEntry).status match {
        case st if st.is(GIT_STATUS_WT_NEW)         => FileStatus.WT_NEW
        case st if st.is(GIT_STATUS_WT_MODIFIED)    => FileStatus.WT_MODIFIED
        case st if st.is(GIT_STATUS_INDEX_NEW)      => FileStatus.INDEX_NEW
        case st if st.is(GIT_STATUS_INDEX_MODIFIED) => FileStatus.INDEX_NEW
        case st if st.is(GIT_STATUS_INDEX_DELETED)  => FileStatus.INDEX_DELETE
        case st if st.is(GIT_STATUS_WT_DELETED)     => FileStatus.WT_DELETED
        case o =>
          FileStatus.OTHER
      }

    }
    .groupBy(identity)
    .mapValues(_.size)

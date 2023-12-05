package libgit2

import libgit.functions.*
import libgit.types.*

import scala.scalanative.unsafe.*

import scala.scalanative.unsigned.*
import scala.collection.MapView

import scala.scalanative.libc.stdio
import scala.scalanative.runtime.libc

enum FileStatus(val icon: String):
  override def toString: String = icon
  case WT_NEW extends FileStatus("👀")
  case WT_MODIFIED extends FileStatus("🚧")
  case WT_DELETED extends FileStatus("🗑️")
  case INDEX_NEW extends FileStatus("🚀")
  case INDEX_DELETE extends FileStatus("🔥")
  case OTHER extends FileStatus("⁉️")

case class Repo(
    val repoRef: Ptr[git_repository],
    head: Ptr[git_reference],
    upstream: Option[Ptr[git_reference]]
) {

  def status(using z: Zone): Ptr[git_status_options] =
    val statusOptionPtr = git_status_options()
    git_status_options_init(statusOptionPtr, 1.toUInt)
    val statusOption = !statusOptionPtr
    statusOption.show = git_status_show_t.GIT_STATUS_SHOW_INDEX_AND_WORKDIR
    statusOption.flags = (git_status_opt_t.GIT_STATUS_OPT_EXCLUDE_SUBMODULES
      | git_status_opt_t.GIT_STATUS_OPT_INCLUDE_UNTRACKED).uint
    statusOptionPtr

  def branchName: String =
    val branch = git_reference_shorthand(head)
    val branchName = fromCString(branch)
    branchName

  def upstreamName(using z: Zone): Option[String] =
    upstream.map { upstream =>
      val shorthand =
        fromCString(git_reference_shorthand(upstream))
      shorthand

    }
  def upstreamStatus(using z: Zone): Option[(Int, Int)] =
    upstream.map { upstream =>

      val ahead = alloc[size_t](1)
      val behind = alloc[size_t](1)

      val masterOid = alloc[git_oid](1)
      val originMasterOid = alloc[git_oid](1)

      git_reference_name_to_id(masterOid, repoRef, git_reference_name(head));
      git_reference_name_to_id(
        originMasterOid,
        repoRef,
        git_reference_name(upstream)
      );

      git_graph_ahead_behind(ahead, behind, repoRef, masterOid, originMasterOid)
      ((!ahead).toInt, (!behind).toInt)
    }

  /** Get the files status of the repository.
    *
    * @param z
    *   Zone to allocate memory in
    * @return
    */
  def diffs()(using z: Zone): MapView[FileStatus, Int] =
    import git_status_t.*
    // Allocate a pointer to a pointer to a status list
    val statusPtr = alloc[Ptr[git_status_list]](1)
    // Get the status list
    val stats = git_status_list_new(statusPtr, repoRef, status)
    // Get the number of entries in the status list
    val diffs = git_status_list_entrycount(!statusPtr)
    // Iterate over the entries in the status list
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
      .view
      .mapValues(_.size)

}

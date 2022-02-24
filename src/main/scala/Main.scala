import scala.scalanative.unsafe._

import scalanative.unsafe.stackalloc
import scalanative.libc.stdlib
import scala.scalanative.runtime.struct

object Main {
  def main(args: Array[String]): Unit = {
    import LibGit2._
    git_libgit2_init()

    val repo: Ptr[Ptr[GitRepository]] = stackalloc[Ptr[GitRepository]]()
    val res = git_repository_open(
      repo,
      c"/Users/onouguier/projects/perso/hellos/gistrot"
    )
    if (git_repository_is_bare(!repo) == 1)
      println("Bare")
    else
      println("Workdir")

    val status = stackalloc[Ptr[GitStatusList]]()
    println(status)
    val opts = stackalloc[git_status_options]()

  }
}

@link("git2")
@extern
object LibGit2 {
  type GitRepository = extern
  type GitStatusList = extern
  type GitStatusOptions = extern
  type git_status_show_t = extern
  type git_strarray = extern
  type git_tree = extern
  type git_status_options = CStruct5[
    Int,
    git_status_show_t,
    Int,
    git_strarray,
    Ptr[
      git_tree
    ]
  ]

  type status_opts = CStruct4[git_status_options, Ptr[Char], Ptr[Char], Int]

  /*
FORMAT_DEFAULT   = 0,
  FORMAT_LONG      = 1,
  FORMAT_SHORT     = 2,
  FORMAT_PORCELAIN = 3,
   */
  class status_format_t(val value: CInt) extends AnyVal
  val FORMAT_DEFAULT: status_format_t = extern
  val FORMAT_SHORT: status_format_t = extern
  val FORMAT_PORCELAIN: status_format_t = extern

  def git_libgit2_init(): Unit = extern

  //int git_repository_open(git_repository **out, const char *path);
  def git_repository_open(out: Ptr[Ptr[GitRepository]], path: CString): Int =
    extern

  //int git_status_list_new(git_status_list **out, git_repository *repo, const git_status_options *opts);
  def git_status_list_new(
      out: Ptr[Ptr[GitStatusList]],
      repo: Ptr[GitRepository],
      opts: Ptr[GitStatusOptions]
  ): Int = extern
  //size_t git_status_list_entrycount(git_status_list *statuslist);
  def git_status_list_entrycount(status: GitStatusList): CSize = extern

  def git_repository_is_bare(repo: Ptr[GitRepository]): Int = extern
}

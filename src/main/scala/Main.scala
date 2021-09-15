import scala.scalanative.unsafe._

import scalanative.unsafe.stackalloc
import scalanative.libc.stdlib

object Main {
  def main(args: Array[String]): Unit = {
    println("Hello, world!")
    import LibGit2._
    val repo = stackalloc[Ptr[GitRepository]]
    println(s"Hello, world! $repo")
    val res = git_repository_open(repo, c".")
    println(res)
    //  LibGit2.git_status_list_entrycount(null)
  }
}

@link("git2")
@extern
object LibGit2 {
  type GitRepository = extern
  type GitStatusList = Ptr[Byte]
  //int git_repository_open(git_repository **out, const char *path);
  def git_repository_open(out: Ptr[Ptr[GitRepository]], path: CString): Int =
    extern

  //size_t git_status_list_entrycount(git_status_list *statuslist);
  def git_status_list_entrycount(status: GitStatusList): CSize = extern

}

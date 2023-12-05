package libgit2

import libgit.functions.*
import libgit.types.*
import scala.scalanative.unsafe.*

/** Scala friendly wrappers
  */

object LibGit2:
  /** Helper to convert a C function call to an Option.
    *
    * If the function succeed and returns 0, the pointer is Some, otherwise
    * None.
    *
    * Memory is allocated in the given zone.
    *
    * @param f
    *   Function to call
    * @param z
    *   Zone to allocate memory in
    * @return
    */
  private def asOption[P](f: Ptr[Ptr[P]] => CInt)(implicit
      z: Zone
  ): Option[Ptr[Ptr[P]]] =
    val repoRef = alloc[Ptr[P]](1)
    if f(repoRef) == 0 then Some(repoRef)
    else None

  /** Helper to convert a C function call to an Option.
    *
    * If the function succeed and returns 0, the pointer is Some, otherwise
    * None.
    *
    * Memory is allocated in the given zone.
    *
    * @param f
    *   Function to call
    * @param z
    *   Zone to allocate memory in
    * @return
    */
  private def repoAsOption[P](f: Ptr[git_buf] => CInt)(implicit
      z: Zone
  ): Option[Ptr[git_buf]] =
    val repoRef = alloc[git_buf](1)
    if f(repoRef) == 0 then Some(repoRef)
    else None

  /** Open a repository at the given path.
    *
    * @param path
    * @param z
    *   Zone to allocate memory in
    * @return
    */
  def repo(path: CString)(implicit z: Zone): Option[Repo] =
    for {
      path <- repoAsOption(git_repository_discover(_, c".", 1, c""))
      repo <- asOption(git_repository_open(_, (!path).ptr))
      head <- asOption(git_repository_head(_, !repo))
      upstream = asOption(git_branch_upstream(_, !head))
    } yield Repo(!repo, !head, upstream.map(!_))

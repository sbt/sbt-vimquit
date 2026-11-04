package sbtvimquit

import sbt.*
import Keys.*
import sbt.internal.util.complete.Parser

object VimquitPlugin extends AutoPlugin {
  import Parser.*
  override def trigger = allRequirements

  lazy val quitParser: Parser[Unit] = (":q": Parser[String]) ^^^ (())

  override def globalSettings = Seq(
    commands += Command.arb[Unit](_ => quitParser) { (s: State, _) => "exit" :: s }
  )
}

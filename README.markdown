sbt-vimquit
===========

install
-------

Create `~/.sbt/1.0/plugins/user.sbt`

```scala
addSbtPlugin("com.eed3si9n" % "sbt-vimquit" % "0.1.0")
```

usage
-----

This plugin adds `:q` command to quit sbt shell:

```
> :q
```

This allows you to quit Scala REPL and sbt shell in the same way.
Yes, I am aware of `Ctrl + D`.

License
-------

MIT License

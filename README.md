# TypeTransform
WIP. Small program that will transform data to IR and IR to another type of data (like INI->JSON)

---

## What is TypeTransform

TypeTransform aims to be an easy yet useful way to transform data. It will transform different types to another one easily.

## Why I made it

I made it to learn more about Kotlin, as it's a programming language I have always wanted to test.

## What works so far

* Simple INI to IR:
```INI
[TEST]
willitwork=true
indeedseemstowork=ye,butsomeriskythings
whatdoyoumean=drops,strangerulesthatseemtoalwaysworkuntiltheydont
[AHHH]
idc=true++
```
generates
```
TEST: {willitwork:true,indeedseemstowork:ye,butsomeriskythings,whatdoyoumean:drops,strangerulesthatseemtoalwaysworkuntiltheydont} AHHH: {idc:true++}
```
* Simple IR to Ini (opposite of last example)
* Simple IR <-> TOML

> All transformations are indev and not really well done.

## Roadmap: what can you expect

Right now, TypeTransform is on very inital stage, so this is what I planned for its future:
* JSON <-> IR
* YAML <-> IR
* CSV  <-> IR
* GUI

val s = "2345::Fury::894.90"

val arr = s.split("::")
(arr(0), arr(1), arr(2))


val t = "2,3,4"
val h = (1, t.split(",").foreach(rating => rating.toDouble))

val d = Some("Saeed")
val a = d.get

val fill = List.fill(2)((1, 2))

fill.unzip






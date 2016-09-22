val ua = "Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B405"
val uar = ua.replace(" (KHTML, like Gecko)", "")

val us = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36"
val usr = us.replace(" (KHTML, like Gecko)", "")

val ao = "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:47.0) Gecko/20100101 Firefox/47.0"
val all = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_5) AppleWebKit/537.36 Chrome/51.0.2704.106 Safari/537.36"

val ak = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_5)-- AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.106 Safari/537.36"

val mozilCompa = "([a-zA-Z]*[//]{1}\\d+\\.\\d+)"
val sysDetails = "(\\([a-zA-Z0-9\\s(;_.\\-/:)]*\\))"
val brPlatVer = "(\\bFirefox|Chromium|Safari|Chrome|Opera|Mobile\\b)([//]{1}[0-9a-zA-Z\\.]*)"
val engineVer = "(\\bGecko|AppleWebKit|Trident|Opera|Chrome\\b[//]{1}[\\d\\.\\d]*)"
val extraEngineVer = "\\s" + engineVer + "{0,1}"

val uaRegex = (mozilCompa + "\\s" + sysDetails + "\\s"  + engineVer + ".*" + brPlatVer).r
val unan =  uaRegex.unanchored

val o = unan findAllIn ak
o.isEmpty
o group 0
o group 1
o group 2
o group 3
o group 4
//o group 5



case class UA(mozila: String, system: String, platform: String, plDetails: String)


def parsUA(ua : String) : UA = {
  val uaRegex = ("([a-zA-Z]*[//]{1}\\d+\\.\\d+)\\s(\\([a-zA-Z0-9\\s(;_\\-/)]*\\))\\s([a-zA-Z]*[//][0-9\\.]*)" +
    "\\s([a-zA-Z0-9\\s(;,_\\-)]*)\\s(.*)").r
  val unan =  uaRegex.unanchored

  val o = unan findAllIn ua
  UA(o group 1, o group 2,o group 3, o group 4)
}
//
//"Chrome/51.0.2704.103" matches "(\\bGecko|AppleWebKit|Trident|Opera|Chrome\\b)[//][0-9a-zA-Z\\.]*"
//"Safari/537.36" matches brPlatVer
//
val anine = "AppleWebKit/537.36" matches "\\bGecko|AppleWebKit|Trident|Opera|Chrome\\b[//][0-9a-zA-Z\\.]*"
val l = "\\bGecko|AppleWebKit|Trident|Opera|Chrome\\b[//]{1}(\\d+\\.*[a-zA-Z]*)".r
val res = l.unanchored findAllIn   "Gecko/20100101"
res group 0
res group 1
//res group 2

"/20100101" matches "[//]{1}(\\d+\\.*[a-zA-Z]*)"
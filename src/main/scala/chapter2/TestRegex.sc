val date = """(\d\d\d\d)-(\d\d)-(\d\d)""".r
val embeddedDate = date.unanchored
"Date: 2004-01-20 17:25:18 GMT (10 years, 28 weeks, 5 days, 17 hours and 51 minutes ago)" match {
  case embeddedDate(a, b, c) => print(b)
}

//val str = ".*(\"obj_type\":\"\\w*\"),.*(\"obj_id\":\"\\w*\")(,.*)(\"action\":\"\\w*\").*".r
val str = ".*(\"obj_type\":\"[a-zA-Z\\s\\p{Punct}]*\"),.*(\"obj_id\":\"[a-zA-Z\\s\\p{Punct}]*\"),.*(\"action\":\"\\w*\").*".r
//val str = "(\"obj_type:\"\\w*\"),(\"obj_id\":\".*\"),(\"action\":\"\\w*\")".r
val log1 = "{\"obj_type\":\"main_category_title\",\"obj_id\":\"Professional, Scientific, and Technical Services\",\"action\":\"hover\",\"uuid\":\"83e28957-3a80-4d3c-b189-339fe0d66c4b\",\"timestamp\":1467962138967,\"type\":\"Event\",\"ua\":\"Mozilla\\/5.0 (Macintosh; Intel Mac OS X 10_11_5) AppleWebKit\\/537.36 (KHTML, like Gecko) Chrome\\/51.0.2704.106 Safari\\/537.36\"}"
val log2 = "{\"obj_type\":\"menu_item\",\"uuid\":\"83e28957-3a80-4d3c-b189-339fe0d66c4b\",\"obj_id\":\"Sign In\",\"ua\":\"Mozilla\\/5.0 (Macintosh; Intel Mac OS X 10_11_5) AppleWebKit\\/537.36 (KHTML, like Gecko) Chrome\\/51.0.2704.106 Safari\\/537.36\",\"timestamp\":1467962141814,\"action\":\"hover\",\"type\":\"Event\"}";
//val toparse = "{\"obj_type\":\"main_category_title\",\"uuid\":\"83e28957-3a80-4d3c-b189-339fe0d66c4b\",\"obj_id\":\"Professional, Scientific, and Technical Services\",\"ua\":\"Mozilla\\/5.0 (Macintosh; Intel Mac OS X 10_11_5) AppleWebKit\\/537.36 (KHTML, like Gecko) Chrome\\/51.0.2704.106 Safari\\/537.36\",\"timestamp\":1467962138967,\"action\":\"hover\",\"type\":\"Event\"}"
val embeded = str.unanchored
log2 match {
  case embeded(objType, objId, action) => (getValueOf(objType), getValueOf(objId), getValueOf(action))
}


def getValueOf(jsonAttr : String) : String = {
  jsonAttr.split(":")(1)
}
val f = str findAllIn  log2
f group 1
f group 2
f group 3


parseLogLine(log1) match {
  case Some(LogTuple(a, b, c)) => (b, 1)
  case None =>
}

case class LogTuple(objType: String, objId : String, action: String)

def parseLogLine(line: String) : Option[LogTuple] = {
  val regex = ".*(\"obj_type\":\"[a-zA-Z\\s\\p{Punct}]*\"),.*(\"obj_id\":\"[a-zA-Z\\s\\p{Punct}]*\"),.*(\"action\":\"\\w*\").*".r
  val embeddedMatch = regex.unanchored

  line match {
    case embeddedMatch(objType, objId, action) => Some(LogTuple(getValueOf(objType), getValueOf(objId), getValueOf(action)))
    case _ => None
  }

}

val a =  Array(("Services",477), ("Community",553), ("Sign Up",565), ("Marketplace",580), ("About",594), ("Contact Us",711))
a.reverse.foreach((a) => println(a._1 + ":" + a._2))

























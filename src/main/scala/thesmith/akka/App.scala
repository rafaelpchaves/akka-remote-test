package thesmith.akka

import scala.util.Random

object App {
  def main(args: Array[String]) {
    if (args.contains("sender")) {
      val app = new SenderApplication
      println("Started Sender Application - sending messages")

      while (true) {
        app.send("message:"+Random.nextInt(100))

        Thread.sleep(300)
      }
    } else {
      new ReceiverApplication
    }
  }
}
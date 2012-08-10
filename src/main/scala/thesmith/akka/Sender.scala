package thesmith.akka

import akka.kernel.Bootable
import com.typesafe.config.ConfigFactory
import scala.util.Random
import akka.actor._
import akka.routing._

class SenderApplication extends Bootable {
  val addresses = Seq(
    Address("akka", "ReceiverApplication", "127.0.0.1", 2552),
    Address("akka", "ReceiverApplication", "127.0.0.1", 2553))
  val system = ActorSystem("SenderApplication", ConfigFactory.load.getConfig("sender"))
  val actor = system.actorOf(Props[ReceivingActor].withRouter(RemoteRouterConfig(RoundRobinRouter(10), addresses)))

  def send(message: String) {
    println(this.getClass.getSimpleName + " - Sending "+message)
    actor ! message
  }

  def startup() {
  }

  def shutdown() {
    system.shutdown()
  }
}

object SenderApp {
  def main(args: Array[String]) {
    val app = new SenderApplication
    println("Started Sender Application - sending messages")

    while (true) {
      app.send("message:"+Random.nextInt(100))

      Thread.sleep(300)
    }
  }
}

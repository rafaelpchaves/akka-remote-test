package thesmith.akka

import akka.kernel.Bootable
import com.typesafe.config.ConfigFactory
import akka.actor._
import akka.routing._

class SenderApplication extends Bootable {
  val system = ActorSystem("sender", ConfigFactory.load.getConfig("sender"))
  val actor = system.actorFor("akka://receiver@receiver:2600/user/receiver")

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

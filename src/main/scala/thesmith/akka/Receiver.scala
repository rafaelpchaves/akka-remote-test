package thesmith.akka

import akka.kernel.Bootable
import akka.actor.{ Props, Actor, ActorSystem }
import com.typesafe.config.ConfigFactory
import scala.util.Random
import akka.actor._

class ReceivingActor extends Actor {
  def receive = {
    case message => println(this.getClass.getSimpleName+" - Recieved "+message)
  }
}

class ReceiverApplication() extends Bootable {
  val system = ActorSystem("receiver", ConfigFactory.load.getConfig("receiver"))
  val actor = system.actorOf(Props[ReceivingActor], "receiver")

  def startup() {
  }

  def shutdown() {
    system.shutdown()
  }
}

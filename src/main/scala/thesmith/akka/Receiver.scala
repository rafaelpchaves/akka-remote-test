package thesmith.akka

import akka.kernel.Bootable
import akka.actor.{ Props, Actor, ActorSystem }
import com.typesafe.config.ConfigFactory
import scala.util.Random
import akka.actor._

class ReceivingActor extends Actor {
  def receive = {
    case message: String ⇒ println(this.getClass.getSimpleName+" - Recieved "+message)
  }
}

class ReceiverApplication(val num: Int) extends Bootable {
  val system = ActorSystem("ReceiverApplication", ConfigFactory.load.getConfig("receiver"+num))

  def startup() {
  }

  def shutdown() {
    system.shutdown()
  }
}

object Receiver1App {
  def main(args: Array[String]) {
    val app = new ReceiverApplication(1)
    println("Started Receiver Application 1 - receiving messages")
  }
}

object Receiver2App {
  def main(args: Array[String]) {
    val app = new ReceiverApplication(2)
    println("Started Receiver Application 2 - receiving messages")
  }
}

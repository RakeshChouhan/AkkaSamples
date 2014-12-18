import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 * 
 */

/**
 * @author Rakesh
 *
 */
public class AkkaWithMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ActorSystem system = ActorSystem.create("HelloAKKA");
		ActorRef helloRef = system.actorOf(Props.create(HelloActor.class));
		helloRef.tell("Hello Akka World", helloRef.noSender());
		system.shutdown();
	}

}

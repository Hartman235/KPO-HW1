import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

class Smth

@Configuration
class AppConfig {

	@Bean
	fun func1(): Smth {
		return Smth()
	}
}

@Component
class Cl1 {

}

interface Interf {

}

class Somebody : Interf {

}

@Configuration
class ZooConfig{
	@Bean
	@ConditionalOnProperty(name = ["version"], havingValue = "true")
	fun func2(): Interf {
		return Somebody()
	}

}

fun main(args: Array<String>) {
	val ctxt = runApplication<DemoApplication>(*args)

	val car1 = ctxt.getCar(Smth::class.java)

	val car2 = ctxt.getCar(Cl1::class.java)

	val car3 = ctxt.getCar(Interf::class.java)

}
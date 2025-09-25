package dev.sijunyang.monitoringdemo

//import io.pyroscope.http.Format
//import io.pyroscope.javaagent.EventType
//import io.pyroscope.javaagent.PyroscopeAgent
//import io.pyroscope.javaagent.config.Config
//import io.pyroscope.labels.v2.Pyroscope
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MonitoringDemoApplication

// TODO: 이것도 가능하긴 한거 같은데, 관리 관점에서는 외부에서 주입하는게 더 깔끔하지 않나 싶음.
// Ref:
// - https://grafana.com/docs/pyroscope/latest/configure-client/language-sdks/java/
// - https://github.com/grafana/pyroscope/tree/main/examples/language-sdk-instrumentation/java/rideshare
fun main(args: Array<String>) {
//    Pyroscope.setStaticLabels(
//        mapOf(
//            "hostname" to env("HOSTNAME", "localhost")
//        )
//    )
//
//    if (!PyroscopeAgent.isStarted()) {
//        // If we have not started the sdk with -javaagent (for example running from an IDE)
//        // allow starting the sdk here for convenience
//        PyroscopeAgent.start(Config.Builder()
//            .setApplicationName("monitoring-demo")
//            .setProfilingEvent(EventType.ITIMER)
//            .setFormat(Format.JFR)
//            .setServerAddress(env("", "http://localhost:4040"))
//            .build())
//    }
    runApplication<MonitoringDemoApplication>(*args)
}
//fun env(key: String, fallback: String): String = System.getenv(key) ?: fallback

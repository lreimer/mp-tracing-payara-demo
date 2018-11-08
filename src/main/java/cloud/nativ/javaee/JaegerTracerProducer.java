package cloud.nativ.javaee;

import io.jaegertracing.Configuration;
import io.opentracing.Tracer;
import io.opentracing.util.GlobalTracer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class JaegerTracerProducer {

    public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
        Configuration configuration = Configuration.fromEnv();
        GlobalTracer.register(configuration.getTracer());
    }

    @JaegerTracer
    public Tracer createJaegerTracer() {
        return GlobalTracer.get();
    }
}

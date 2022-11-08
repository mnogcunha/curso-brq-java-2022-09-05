package com.brq.ms04.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CopyFilesRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        // a rota é do tipo arquivo e parte da pasta input
        from("file:input")
                // a rota é do tipo arquivo e tem como destino a pasta output
                .to("file:output");
    }
}

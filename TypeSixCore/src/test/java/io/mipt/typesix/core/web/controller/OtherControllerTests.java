package io.mipt.typesix.core.web.controller;

import io.mipt.typesix.core.BaseTest;
import io.mipt.typesix.core.utils.HttpRequestInput;
import org.junit.jupiter.api.Test;

import static io.mipt.typesix.core.web.EndpointsList.*;

public class OtherControllerTests extends BaseTest {
    @Test
    public void testActuatorEndpoint() {
        get(HttpRequestInput.builder().bodyRequested(true).build(), ACTUATOR_BASE_PATH + "/prometheus").getStatusCode().is2xxSuccessful();
        get(HttpRequestInput.builder().build(), ACTUATOR_BASE_PATH).getStatusCode().is2xxSuccessful();
    }

    @Test
    public void testApiDDocsEndpoint() {
        get(HttpRequestInput.builder().build(), SPRING_DOC_PATH).getStatusCode().is2xxSuccessful();
    }

    @Test
    public void testSwaggerPage() {
        get(HttpRequestInput.builder().build(), SWAGGER_UI_BASE_PATH + "/index.html").getStatusCode().is2xxSuccessful();
    }
}

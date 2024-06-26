package io.mipt.typesix.core.web.controller;

import io.mipt.typesix.core.BaseTest;
import io.mipt.typesix.core.utils.HttpRequestInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.mipt.typesix.core.web.EndpointsList.ERROR_PAGE;

public class ErrorControllerTests extends BaseTest {
    @Test
    public void errorPageWithMessageTest() {
        final String message = "message";
        var out = get(HttpRequestInput.builder().bodyRequested(true).mime(Map.of("message", message)).build(), ERROR_PAGE);
        out.getStatusCode().is2xxSuccessful();
        Assertions.assertTrue(out.getContent().contains(message));
    }

    @Test
    public void errorPageWithoutMessageTest() {
        var out = get(HttpRequestInput.builder().bodyRequested(true).build(), ERROR_PAGE);
        out.getStatusCode().is2xxSuccessful();
    }
}

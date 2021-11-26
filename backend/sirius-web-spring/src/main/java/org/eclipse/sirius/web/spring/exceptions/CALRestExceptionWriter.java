package org.eclipse.sirius.web.spring.exceptions;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import org.springframework.stereotype.Component;

@Component
public class CALRestExceptionWriter {
    private final Gson gson;

    public CALRestExceptionWriter(Gson gson) {
        this.gson = gson;
    }

    public void writeException(CALRestException exception, HttpServletResponse response) throws IOException {
        var serializedException = this.gson.toJson(exception);
        response.setContentType("application/json"); //$NON-NLS-1$
        response.setCharacterEncoding("UTF-8"); //$NON-NLS-1$

        response.getWriter().write(serializedException);
    }
}

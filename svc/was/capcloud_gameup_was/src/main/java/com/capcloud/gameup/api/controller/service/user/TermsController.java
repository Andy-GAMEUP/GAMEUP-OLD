package com.capcloud.gameup.api.controller.service.user;

import com.capcloud.gameup.api.common.ServiceLoggerHandler;
import com.capcloud.gameup.api.domain.ResponseVO;
import com.capcloud.gameup.api.domain.StatusCodeVO;
import com.capcloud.gameup.api.domain.database.TB_TERMS;
import com.capcloud.gameup.api.service.user.TermsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/terms")
public class TermsController {

    private final TermsService termsService;

    @GetMapping("/list")
    public ResponseEntity<ResponseVO> getTerms(HttpServletRequest httpServletRequest, @RequestParam(required = false, value = "version") String targetVersion) {
        ResponseVO responseVO = new ResponseVO();

        List<TB_TERMS> termsList = termsService.getTerms();
        responseVO.setData(termsList);

        if (termsList == null || termsList.size() == 0) {
            responseVO.setCodeWithDesc(StatusCodeVO.NOT_FOUND_DATABASE);
        }

        ServiceLoggerHandler.writeLogger(httpServletRequest, HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), responseVO, null);
        return new ResponseEntity<ResponseVO>(responseVO, HttpStatus.OK);
    }
}

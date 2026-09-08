package com.capcloud.gameup.api.controller.admin.user;

import com.capcloud.gameup.api.common.ServiceLoggerHandler;
import com.capcloud.gameup.api.common.exception.ParamErrorException;
import com.capcloud.gameup.api.domain.ResponseVO;
import com.capcloud.gameup.api.domain.StatusCodeVO;
import com.capcloud.gameup.api.domain.database.TB_TERMS;
import com.capcloud.gameup.api.domain.request.TermsReqVO;
import com.capcloud.gameup.api.service.user.TermsService;
import com.capcloud.gameup.api.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/admin/terms")
public class AdminTermsController {

    private final TermsService termsService;

    @GetMapping("/list")
    public ResponseEntity<ResponseVO> getTerms(HttpServletRequest httpServletRequest, @RequestParam(required = false, value = "termsId") String strTermsId) {
        ResponseVO responseVO = new ResponseVO();

        long termsId = StringUtils.stringToLong(strTermsId, 0);

        List<TB_TERMS> termsList = null;
        if (termsId > 0) {
            termsList = termsService.getTermsById(termsId);
        } else {
            termsList = termsService.getTerms();
        }

        if (termsList == null || termsList.size() == 0) {
            responseVO.setCodeWithDesc(StatusCodeVO.NOT_FOUND_DATABASE);
        }

        responseVO.setData(termsList);
        ServiceLoggerHandler.writeLogger(httpServletRequest, HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), responseVO, null);
        return new ResponseEntity<ResponseVO>(responseVO, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<ResponseVO> updateTerms(HttpServletRequest httpServletRequest, @RequestBody TermsReqVO termsReqVO) {
        ResponseVO responseVO = new ResponseVO();

        if (termsReqVO.getId() < 1 || StringUtils.isEmpty(termsReqVO.getContent())) {
            throw new ParamErrorException("Check Required Param >> termsId, termsContent >> " + termsReqVO);
        }

        termsService.updateTerms(termsReqVO);

        ServiceLoggerHandler.writeLogger(httpServletRequest, HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), responseVO, null);
        return new ResponseEntity<ResponseVO>(responseVO, HttpStatus.OK);
    }
}

package com.capcloud.gameup.api.service.user;

import com.capcloud.gameup.api.common.exception.ClientErrorException;
import com.capcloud.gameup.api.common.exception.DbErrorException;
import com.capcloud.gameup.api.domain.database.TB_TERMS;
import com.capcloud.gameup.api.domain.request.TermsReqVO;
import com.capcloud.gameup.persistence.mapper.mysql.user.TermsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TermsService {

    @Resource
    private TermsMapper termsMapper;

    public List<TB_TERMS> getTerms() {
        List<TB_TERMS> termsList = null;
        try {
            termsList = termsMapper.selectTerms();
        } catch (Exception e) {
            throw new DbErrorException(e.toString());
        }
        return termsList;
    }

    public List<TB_TERMS> getTermsById(long termsId) {
        List<TB_TERMS> termsList = null;
        try {
            termsList = termsMapper.selectTermsById(termsId);
        } catch (Exception e) {
            throw new DbErrorException(e.toString());
        }
        return termsList;
    }

    public void updateTerms(TermsReqVO termsReqVO) {
        try {
            int updatedCnt = termsMapper.updateTerms(termsReqVO);
            if (updatedCnt == 0) {
                throw new ClientErrorException("[TermsService][updateTerms] updateCnt is 0");
            }
        } catch (Exception e) {
            throw new DbErrorException("[TermsService][updateTerms] " + e);
        }
    }
}

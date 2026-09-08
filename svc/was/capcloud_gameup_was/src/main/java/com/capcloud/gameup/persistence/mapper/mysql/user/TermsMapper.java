package com.capcloud.gameup.persistence.mapper.mysql.user;

import com.capcloud.gameup.api.domain.database.TB_TERMS;
import com.capcloud.gameup.api.domain.request.TermsReqVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TermsMapper {
    List<TB_TERMS> selectTerms();
    List<TB_TERMS> selectTermsById(@Param("termsId") long termsId);
    int updateTerms(@Param("paramVO") TermsReqVO termsReqVO);
}

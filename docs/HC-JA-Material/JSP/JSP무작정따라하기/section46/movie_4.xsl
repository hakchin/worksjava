<?xml version="1.0" encoding="euc-kr" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/TR/WD-xsl">					
  <xsl:template match="/">
    <xsl:for-each select="영화목록/영화">
      영화  <b><xsl:value-of select="제목"/></b>의 주연배우는 
      <xsl:value-of select="주연1"/>
      <xsl:if test="주연2[not(.='')]">
        ,
      </xsl:if>
      <xsl:value-of select="주연2"/>
      <xsl:if test="주연3[not(.='')]">
        ,
      </xsl:if>
      <xsl:value-of select="주연3"/>
      입니다.
      <br/>
    </xsl:for-each>
  </xsl:template>
</xsl:stylesheet>
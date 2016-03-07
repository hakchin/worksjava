<?xml version="1.0" encoding="euc-kr" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/TR/WD-xsl">					
  <xsl:template match="/">
    <html>
      <body>
      <b>[영화등급]</b>
             <xsl:for-each select="영화등급/영화">
        <li/>영화 <b><xsl:value-of select="제목"/></b>의 관람기준은 
	       <xsl:choose>
	         <xsl:when test="등급[.=1]">미성년자 관람가</xsl:when>
                 <xsl:when test="등급[.=2]">15세 이상 관람가</xsl:when>
                 <xsl:otherwise>미성년자 관람불가</xsl:otherwise>
	      </xsl:choose>
	    입니다.<br/>
          </xsl:for-each>
        </body>
      </html>
    </xsl:template>
</xsl:stylesheet>
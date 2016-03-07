<?xml version="1.0" encoding="euc-kr" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/TR/WD-xsl">					
  <xsl:template match="/">
    <html>
      <title>
        <xsl:value-of select="/영화/제목"/>
      </title>
      <body>
        [쉬리의 감독]<br/>
          <xsl:value-of select="영화/쉬리/감독"/><br/><br/>
        [친구의 감독]<br/>
          <xsl:value-of select="영화/친구/감독"/><br/><br/>
        [공동 경비구역 JSA의 감독]<br/>
          <xsl:value-of select="영화/JSA/감독"/>			
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
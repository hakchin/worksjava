<?xml version="1.0" encoding="euc-kr" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/TR/WD-xsl">					
  <xsl:template match="/">
    <html>
      <title>
        <xsl:value-of select="/영화/제목"/>
      </title>
      <body>
        [쉬리]<br/>
        <xsl:for-each select="영화/쉬리/주연">
          <xsl:value-of select="."/><br/>
        </xsl:for-each>
        <br/>
	[친구]<br/>
        <xsl:for-each select="영화/친구/주연">
          <xsl:value-of select="."/><br/>
        </xsl:for-each>
        <br/>
        [공동 경비구역 JSA]<br/>
        <xsl:for-each select="영화/JSA/주연">
          <xsl:value-of select="."/><br/>
        </xsl:for-each>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
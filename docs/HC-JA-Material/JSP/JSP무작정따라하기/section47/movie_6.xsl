<?xml version="1.0" encoding="euc-kr" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/TR/WD-xsl">					
  <xsl:template match="/">
    <html>
      <body>
      <b><xsl:value-of select="영화목록/제목"/></b>
        <br/>
	[감독리스트]<br/>
          <xsl:apply-templates select="영화목록/영화/감독"/> 
	  <br/>
	 [주연리스트]<br/>
	   <xsl:apply-templates select="영화목록/영화"/>
        </body>
      </html>
    </xsl:template>
    <xsl:template match="영화목록/영화/감독">
      <xsl:value-of select="."/><br/>
    </xsl:template>
    <xsl:template match="영화목록/영화">
      <xsl:for-each select="주연"> 
        <xsl:value-of select="."/><br/>
      </xsl:for-each>
    </xsl:template>
  </xsl:stylesheet>

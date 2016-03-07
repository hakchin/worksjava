<?xml version="1.0" encoding="euc-kr"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/TR/WD-xsl">					
  <xsl:template match="/">
    <html>
      <body>
        <xsl:element name="a">
          <xsl:attribute name="href">
            <xsl:value-of select="다른곳으로연결/가는곳의주소"/>
          </xsl:attribute>
          <xsl:value-of select="다른곳으로연결/가고자하는곳"/>
        </xsl:element>
      </body>
    </html>
  </xsl:template>	
</xsl:stylesheet>
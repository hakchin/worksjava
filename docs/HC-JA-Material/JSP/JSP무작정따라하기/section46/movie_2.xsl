<?xml version="1.0" encoding="euc-kr" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/TR/WD-xsl">					
  <xsl:template match="/">
    <html>
      <title>
        <xsl:value-of select="/��ȭ/����"/>
      </title>
      <body>
        [����]<br/>
        <xsl:for-each select="��ȭ/����/�ֿ�">
          <xsl:value-of select="."/><br/>
        </xsl:for-each>
        <br/>
	[ģ��]<br/>
        <xsl:for-each select="��ȭ/ģ��/�ֿ�">
          <xsl:value-of select="."/><br/>
        </xsl:for-each>
        <br/>
        [���� ��񱸿� JSA]<br/>
        <xsl:for-each select="��ȭ/JSA/�ֿ�">
          <xsl:value-of select="."/><br/>
        </xsl:for-each>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
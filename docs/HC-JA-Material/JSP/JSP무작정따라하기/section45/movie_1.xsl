<?xml version="1.0" encoding="euc-kr" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/TR/WD-xsl">					
  <xsl:template match="/">
    <html>
      <title>
        <xsl:value-of select="/��ȭ/����"/>
      </title>
      <body>
        [������ ����]<br/>
          <xsl:value-of select="��ȭ/����/����"/><br/><br/>
        [ģ���� ����]<br/>
          <xsl:value-of select="��ȭ/ģ��/����"/><br/><br/>
        [���� ��񱸿� JSA�� ����]<br/>
          <xsl:value-of select="��ȭ/JSA/����"/>			
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
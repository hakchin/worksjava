<?xml version="1.0" encoding="euc-kr" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/TR/WD-xsl">					
  <xsl:template match="/">
    <html>
      <body>
      <b><xsl:value-of select="��ȭ���/����"/></b>
        <br/>
	[��������Ʈ]<br/>
          <xsl:apply-templates select="��ȭ���/��ȭ/����"/> 
	  <br/>
	 [�ֿ�����Ʈ]<br/>
	   <xsl:apply-templates select="��ȭ���/��ȭ"/>
        </body>
      </html>
    </xsl:template>
    <xsl:template match="��ȭ���/��ȭ/����">
      <xsl:value-of select="."/><br/>
    </xsl:template>
    <xsl:template match="��ȭ���/��ȭ">
      <xsl:for-each select="�ֿ�"> 
        <xsl:value-of select="."/><br/>
      </xsl:for-each>
    </xsl:template>
  </xsl:stylesheet>

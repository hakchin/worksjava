<?xml version="1.0" encoding="euc-kr" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/TR/WD-xsl">					
  <xsl:template match="/">
    <html>
      <body>
      <b>[��ȭ���]</b>
             <xsl:for-each select="��ȭ���/��ȭ">
        <li/>��ȭ <b><xsl:value-of select="����"/></b>�� ���������� 
	       <xsl:choose>
	         <xsl:when test="���[.=1]">�̼����� ������</xsl:when>
                 <xsl:when test="���[.=2]">15�� �̻� ������</xsl:when>
                 <xsl:otherwise>�̼����� �����Ұ�</xsl:otherwise>
	      </xsl:choose>
	    �Դϴ�.<br/>
          </xsl:for-each>
        </body>
      </html>
    </xsl:template>
</xsl:stylesheet>
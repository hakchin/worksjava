<?xml version="1.0" encoding="euc-kr" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/TR/WD-xsl">					
  <xsl:template match="/">
    <xsl:for-each select="��ȭ���/��ȭ">
      ��ȭ  <b><xsl:value-of select="����"/></b>�� �ֿ����� 
      <xsl:value-of select="�ֿ�1"/>
      <xsl:if test="�ֿ�2[not(.='')]">
        ,
      </xsl:if>
      <xsl:value-of select="�ֿ�2"/>
      <xsl:if test="�ֿ�3[not(.='')]">
        ,
      </xsl:if>
      <xsl:value-of select="�ֿ�3"/>
      �Դϴ�.
      <br/>
    </xsl:for-each>
  </xsl:template>
</xsl:stylesheet>
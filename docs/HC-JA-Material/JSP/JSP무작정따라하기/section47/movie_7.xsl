<?xml version="1.0" encoding="euc-kr" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/TR/WD-xsl">					
  <xsl:template match="/">
    <p><li/> 
    <!-- Ž���� ��Ʈ���� ���Ͱ˻��ϴ� �ܼ��� ���� ��� ������ �̸��� ǥ�� -->
    <xsl:value-of select="��ȭ/����/����/�̸�"/>�� ������
    <xsl:value-of select="��ȭ/����/����/����"/>�Դϴ�.<br/>
    </p>
    <p>
    <li/>
    <!-- ���� �̸��� �±׵��� ������ �� ���ϴ� �˻� ���__Ʋ�� �� -->
    <xsl:value-of select="��ȭ/����/�ֿ�/�̸�"/>�� ������ 
    <xsl:value-of select="��ȭ/����/�ֿ�/����"/>�Դϴ�.<br/>
    </p>
    <p>
    <li/>
    <!-- ���� �̸��� �±׵��� ������ �� ���ϴ� �˻� ���__���� �� -->
    <xsl:value-of select="��ȭ/����/�ֿ�/�̸�[.='�۰�ȣ']"/>�� ��������
    <xsl:value-of select="��ȭ/����/�ֿ�[�̸�='�۰�ȣ']/������"/>�Դϴ�.<br/>
    </p>
    <p>   
    <!-- �Ӽ����� ���ؼ� Ư�� ��� ������ ������ ���� ��� [1]-->
    <li/>���߳⵵�� 1995���� ����<br/>
    <xsl:for-each select="��ȭ/����/�ֿ�[������/@���߳⵵='1995']">
      <xsl:value-of select="�̸�"/> (<xsl:value-of select="������/@���߳⵵"/>�� ����)<br/>
    </xsl:for-each>
    </p>
    <p>
    <!-- �Ӽ����� ���ؼ� Ư�� ��� ������ ������ ���� ��� [2]-->
    <li/>���߳⵵�� 1995���� �ƴ� ����<br/>
     <xsl:for-each select="��ȭ/����/�ֿ�[not(������/@���߳⵵='1995')]">
      <xsl:value-of select="�̸�"/> (<xsl:value-of select="������/@���߳⵵"/>�� ����)<br/>
    </xsl:for-each>
    </p>
  </xsl:template>
</xsl:stylesheet>

	

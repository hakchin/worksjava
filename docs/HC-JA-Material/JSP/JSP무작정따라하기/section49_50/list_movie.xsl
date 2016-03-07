<?xml version="1.0" encoding="euc-kr" ?>
  <xsl:stylesheet xmlns:xsl="http://www.w3.org/TR/WD-xsl">	
   <xsl:template match="/">
      <html>
        <body>
          <h3 align="center">��ȭ ���</h3>					
          <xsl:for-each select="list/movie">
            <table align="center" border="1" width="500">
              <tr>
                <td align="center" colspan="4">
                  <xsl:element name="a">
                    <xsl:attribute name="href">
                      <xsl:value-of select="title_url"/>
                    </xsl:attribute>
                    <b><xsl:value-of select="title"/></b>
                  </xsl:element>
                </td>
              </tr>
              <tr>
                <td align="center">���� </td>
                <td colspan="3">
                  <xsl:element name="a">
                    <xsl:attribute name="href">
                      <xsl:value-of select="director_url"/>
                    </xsl:attribute>
                    <xsl:value-of select="director"/>
                  </xsl:element>
                </td>
              </tr>
             <tr>
               <td>�⿬��</td>
               <td colspan="3">
                 <xsl:element name="a">
                   <xsl:attribute name="href">
                     <xsl:value-of select="actor1_url"/>
                   </xsl:attribute>
                   <xsl:value-of select="actor1"/>
                 </xsl:element>
                 <xsl:if test="actor2[not(.='')]"> , </xsl:if>
                 <xsl:element name="a">
                   <xsl:attribute name="href">
                     <xsl:value-of select="actor2_url"/>
                   </xsl:attribute>
                   <xsl:value-of select="actor2"/>
                 </xsl:element>
                 <xsl:if test="actor3[not(.='')]"> , 	</xsl:if>
                 <xsl:element name="a">
                   <xsl:attribute name="href">
                     <xsl:value-of select="actor3_url"/>
                   </xsl:attribute>
                   <xsl:value-of select="actor3"/>
                 </xsl:element>
               </td>
             </tr>
             <tr>
               <td>�󿵽ð�</td>
               <td><xsl:value-of select="time"/></td>
               <td>���</td>
               <td>
                 <xsl:choose>
                   <xsl:when test="grade[.=1]">�̼����� ������</xsl:when>
                   <xsl:when test="grade[.=2]">15�� �̻� ������</xsl:when>
                   <xsl:when test="grade[.=3]">�̼����� �����Ұ�</xsl:when>
                 </xsl:choose>
               </td></tr>
             </table>
             <br/>
           </xsl:for-each>
         </body>
       </html>
    </xsl:template>
  </xsl:stylesheet>

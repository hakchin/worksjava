<?xml version="1.0" encoding="euc-kr" ?>
  <xsl:stylesheet xmlns:xsl="http://www.w3.org/TR/WD-xsl">					
    <xsl:template match="/">
      <html>
        <body>
          <h2 align="center">신상 명세</h2>
          <table align="center" border="1" width="600"  cellpadding="10">
            <tr>
              <td>
                <img width="150" height="200">
                  <xsl:attribute name="src">
                    <xsl:value-of select="list/person/photo"/>
                  </xsl:attribute>
                </img>
              </td>
              <td>
                이름 : <b><xsl:value-of select="list/person/name"/></b><br/><br/>
                데뷔작 :<xsl:value-of select="list/person/startwork"/><br/><br/>
                데뷔년도:<xsl:value-of select="list/person/startyear"/><br/><br/>
                생일 :<xsl:value-of select="list/person/birth"/><br/><br/>
                출연작:<br/><xsl:value-of select="list/person/works"/><br/>			
              </td>
            </tr>
          </table>
          <p align="center"><a href="list_movie.jsp">목록으로..</a></p>
        </body>
      </html>
    </xsl:template>
  </xsl:stylesheet>	
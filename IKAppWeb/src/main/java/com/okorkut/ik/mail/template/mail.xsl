<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	version="1.0" xmlns:xalan="http://xml.apache.org/xslt">
	<xsl:output indent="yes" encoding="utf-8" method="html"
		standalone="yes" />

	<!-- ******* -->
	<xsl:template match="/">
		<html xmlns="http://www.w3.org/1999/xhtml">
			<head>
				<title>
					<xsl:value-of select="//Header" disable-output-escaping="yes"/>
				</title>
			</head>
			
			<body style="margin:0;">


			<table cellpadding="0" cellspacing="0" width="700" align="center" style="font-family:Arial;">
		        	<tr>
		            <td style="background:#29323d;height:115px; border-bottom:5px solid #e95258;" width="190" align="center" valign="middle">
		                <a href="oguzkorkut.com" target="_blank"><img src="https://linux.org.tr/wp-content/themes/linuxtema/images/favicon.png" alt="LINUX" /></a>
		            </td>
		            <td style="background:#29323d;height:115px; border-bottom:5px solid #e95258;  font-size:20px;" align="center" valign="middle">
		                <table style="background:#3e4c5d; color:#ffffff;" cellspacing="0" cellpadding="0">
		                    <tr>
		                        <td style="padding:10px;">
		                            HATA DETAYI
		                        </td>
		                    </tr>
		                </table>
		            </td>
		        </tr>
		        <tr>
		            <td colspan="2" style="border:1px solid #e95258; border-bottom:5px solid #e95258; padding:40px 0 40px 0;">
		                <table cellspacing="0" cellpadding="0" width="620" align="center">
		                    <tr>
		                        <td align="left" style="font-weight:bold; font-size:16px;">
		                        </td>
		                    </tr>
		                       <tr>
		                           <td align="left" style="font-size:14px;">
		                             <xsl:for-each select="//Event">
										<div class="message-box-wrapper red">
											<br />
											<div class="message-box-title">Portal Hata</div>
											<br />
											<br />
											<div class="message-box-content">
												<xsl:value-of select="Message" disable-output-escaping="yes"/>
												<br/>
												<xsl:if test="count(Line) &gt; 0">
													<br/>
													<b>Exception Details :</b> 
													<br/>
													<xsl:for-each select="Line">
														<br />
														<xsl:value-of select="current()" disable-output-escaping="yes"/>
													</xsl:for-each>		
												</xsl:if>								
											</div>
										</div>
									</xsl:for-each>
		                           </td>
		                       </tr>
		                       <tr>
		                           <td align="left" style="font-size:14px;">
		                              website: <a href="oguzkorkut.com">oguzkorkut.com</a>
		                           </td>
		                       </tr>
		                </table>
		            </td>
		            </tr>
		    </table>
			</body>
		</html>
	</xsl:template>


</xsl:stylesheet>
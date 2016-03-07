// Fig. 17.2: SiteSelector.java
// This program uses a button to load a document from a URL.

// Java core packages
import java.net.*;
import java.util.*;
import java.awt.*;
import java.applet.AppletContext;

// Java extension packages
import javax.swing.*;
import javax.swing.event.*;

public class SiteSelector extends JApplet {
   private Hashtable sites;    // site names and URLs
   private Vector siteNames;   // site names
   private JList siteChooser;  // list of sites to choose from

   // read HTML parameters and set up GUI
   public void init()
   {
      // create Hashtable and Vector
      sites = new Hashtable();
      siteNames = new Vector();

      // obtain parameters from HTML document
      getSitesFromHTMLParameters();

      // create GUI components and layout interface
      Container container = getContentPane();
      container.add( new JLabel( "Choose a site to browse" ),
         BorderLayout.NORTH );

      siteChooser = new JList( siteNames );

      siteChooser.addListSelectionListener(

         new ListSelectionListener() {

            // go to site user selected
            public void valueChanged( ListSelectionEvent event )
            {
               // get selected site name
               Object object = siteChooser.getSelectedValue();

               // use site name to locate corresponding URL
               URL newDocument = ( URL ) sites.get( object );

               // get reference to applet container
               AppletContext browser = getAppletContext();

               // tell applet container to change pages
               browser.showDocument( newDocument );
            }

         }  // end anonymous inner class

      ); // end call to addListSelectionListener

      container.add( new JScrollPane( siteChooser ),
         BorderLayout.CENTER );

   }  // end method init

   // obtain parameters from HTML document
   private void getSitesFromHTMLParameters()
   {
      // look for applet parameters in the HTML document
      // and add sites to Hashtable
      String title, location;
      URL url;
      int counter = 0;

      // obtain first site title
      title = getParameter( "title" + counter );

      // loop until no more parameters in HTML document
      while ( title != null ) {

         // obtain site location
         location = getParameter( "location" + counter );
            
         // place title/URL in Hashtable and title in Vector
         try {
 
            // convert location to URL
            url = new URL( location );

            // put title/URL in Hashtable
            sites.put( title, url );
               
               // put title in Vector
            siteNames.add( title );
         }

         // process invalid URL format
         catch ( MalformedURLException urlException ) {
            urlException.printStackTrace();
         }

         ++counter;  

         // obtain next site title
         title = getParameter( "title" + counter );

      }  // end while

   }  // end method getSitesFromHTMLParameters

}  // end class SiteSelector

/**************************************************************************
 * (C) Copyright 2002 by Deitel & Associates, Inc. and Prentice Hall.     *
 * All Rights Reserved.                                                   *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/

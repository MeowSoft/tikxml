package com.tickaroo.tikxml.annotationprocessing.element.path.constructor;

import com.tickaroo.tikxml.annotation.Element;
import com.tickaroo.tikxml.annotation.Path;
import com.tickaroo.tikxml.annotation.Xml;
import com.tickaroo.tikxml.annotationprocessing.element.path.Image;

/**
 * @author Hannes Dorfmann
 */
@Xml
public class DocumentConstructor {

  private Image image;

  DocumentConstructor(@Path("toSkip") @Element Image image){
    this.image = image;
  }

  public Image getImage() {
    return image;
  }
}
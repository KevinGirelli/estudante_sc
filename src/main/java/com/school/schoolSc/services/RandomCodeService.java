package com.school.schoolSc.services;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomCodeService {

  private Random random = new Random();
  public int GenerateLoginCode(){
    String n1 = Integer.toString(random.nextInt(10));
    String n2 = Integer.toString(random.nextInt(10));
    String n3 = Integer.toString(random.nextInt(10));
    String n4 = Integer.toString(random.nextInt(10));
    String n5 = Integer.toString(random.nextInt(10));
    String n6 = Integer.toString(random.nextInt(10));

    String code = n1+n2+n3+n4+n5+n6;
    return Integer.parseInt(code);

  }
}

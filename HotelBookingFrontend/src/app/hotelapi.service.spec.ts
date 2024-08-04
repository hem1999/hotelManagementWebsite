import { TestBed } from '@angular/core/testing';

import { HotelapiService } from './hotelapi.service';

describe('HotelapiService', () => {
  let service: HotelapiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HotelapiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

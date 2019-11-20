import { TestBed } from '@angular/core/testing';

import { ListVendorsService } from './list-vendors.service';

describe('ListVendorsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ListVendorsService = TestBed.get(ListVendorsService);
    expect(service).toBeTruthy();
  });
});

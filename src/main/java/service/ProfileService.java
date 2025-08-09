package service;

import dto.ProfileDTO;
import dto.ResumeDTO;
import exception.JobPortalException;

import java.util.List;

public interface ProfileService {
    public Long createProfile(String email) throws Exception;
    public ProfileDTO getProfile(Long id) throws JobPortalException;
    public ProfileDTO updateProfile(ProfileDTO profileDTO) throws JobPortalException;
public void resume(ResumeDTO resumeDTO) throws JobPortalException;

    public List<ProfileDTO> getAllProfiles() throws JobPortalException;

    public ResumeDTO getResume(Long id) throws JobPortalException;
}
